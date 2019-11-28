package com.dhcc.cn.framework.datechanged;

import com.dhcc.cn.framework.service.mysql.DataChangedServiceImpl;
import com.dhcc.cn.framework.utlis.Setting;
import com.dhcc.cn.framework.vo.DataChangedVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Consumer;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

@Component
@Slf4j
public class MedicalRescueImpl implements DataChangedInterface<Long> {

    @Autowired
    WxMpService mWxMpService;

    @Autowired
    DataChangedServiceImpl mDataChangedService;

    @Override
    public void handleInsert(Long ret) {
        //需要审批的审核院领导
        Optional<DataChangedVo> optional = mDataChangedService.getDataChangedInfo(ret);
        optional.ifPresent(new Consumer<DataChangedVo>() {
            @Override
            public void accept(DataChangedVo dataChangedVo) {
                //1,模板数据
                WxMpTemplateData wxMpTemplateData = new WxMpTemplateData();
                wxMpTemplateData.setName(dataChangedVo.getApproverName());
                wxMpTemplateData.setValue(dataChangedVo.getEventDesc());

                //2,推送消息
                WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
                        .toUser(dataChangedVo.getOpenId())//要推送的用户openid
                        .templateId(Setting.templateId)//模版id
                        .url("https://www.baidu.com/")//点击模版消息要访问的网址
                        .build();
                templateMessage.addData(wxMpTemplateData);
                try {
                    mWxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
                } catch (Exception e) {
                    System.out.println("推送失败：" + e.getMessage());
                }
            }
        });
    }

    @Override
    public void handleUpdate(Long ret) {

    }
}
