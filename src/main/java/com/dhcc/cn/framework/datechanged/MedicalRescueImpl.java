package com.dhcc.cn.framework.datechanged;

import com.dhcc.cn.framework.dto.MedicalRescueForm;
import com.dhcc.cn.framework.utlis.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

@Component
@Slf4j
public class MedicalRescueImpl implements DataChangedInterface<MedicalRescueForm> {

    @Autowired
    WxMpService mWxMpService;

    @Override
    public void handleInsert(MedicalRescueForm medicalRescueForm) {
        //需要审批的审核院领导
        String approver = medicalRescueForm.getApprover();
        log.info(approver);

        //2,推送消息
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                .toUser("o2uKeweoUggoKcBseN8JIEsQUwT0")//要推送的用户openid
                .templateId(Setting.templateId)//模版id
                .url("https://30paotui.com/")//点击模版消息要访问的网址
                .build();
        try {
            mWxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            System.out.println("推送失败：" + e.getMessage());
        }
    }

    @Override
    public void handleUpdate(MedicalRescueForm medicalRescueForm) {

    }
}
