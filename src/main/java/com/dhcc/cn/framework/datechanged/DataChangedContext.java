package com.dhcc.cn.framework.datechanged;


import com.dhcc.cn.framework.enums.TopicEmum;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 发通知
 */
@Component
@Slf4j
public class DataChangedContext {

    public DataChangedInterface getInstance(String topic) {
        DataChangedInterface dataChangedInterface = null;
        switch (topic) {
            case "MedicalRescueDetail":
                dataChangedInterface = new MedicalRescueDetailImpl();
                break;
            case "MedicalRescue":
                dataChangedInterface = new MedicalRescueImpl();
                break;
            default:
                dataChangedInterface = new MedicalRescueDetailImpl();
                break;
        }
        return dataChangedInterface;
    }

    public void handleTopic(DataChangedInterface dataChangedInterface, TopicEmum topicEmum, Object object) {
        switch (topicEmum) {
            case INSERT:
                dataChangedInterface.handleInsert(object);
                break;
            case UPDATE:
                dataChangedInterface.handleUpdate(object);
                break;
            case DELETE:
                break;
            case SELECT:
                break;
        }
    }
}
