package com.dhcc.cn.framework.datechanged;

import com.dhcc.cn.framework.dto.MedicalRescueForm;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MedicalRescueImpl implements DataChangedInterface<MedicalRescueForm> {

    @Override
    public void handleInsert(MedicalRescueForm medicalRescueForm) {
        //需要审批的审核院领导
        String approver = medicalRescueForm.getApprover();
        log.info(approver);
    }

    @Override
    public void handleUpdate(MedicalRescueForm medicalRescueForm) {

    }
}
