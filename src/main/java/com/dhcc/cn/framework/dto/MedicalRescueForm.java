package com.dhcc.cn.framework.dto;

import com.dhcc.cn.framework.pojo.mysql.MedicalRescue;
import com.google.common.base.Converter;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MedicalRescueForm {

    private long id;

    @NotEmpty(message = "报告单位不能为空")
    @Length(min = 1, max = 50)
    private String organization;

    @NotEmpty(message = "报告日期不能为空")
    @Past
    private Date reportDatetime;

    @NotEmpty(message = "报告人不能为空")
    @Length(min = 1, max = 50)
    private String reporter;

    private String phone;

    private String approver;

    private long eventType;

    private long eventLevel;

    @NotEmpty(message = "发生时间")
    @Past
    private Date occurrenceDatetime;

    private String occurrenceAddress;

    @NotEmpty(message = "入院时间")
    @Past
    private Date paadmDatetime;

    private String eventDesc;

    private long totalNumber;

    private long mildNumber;

    private long severeNumber;

    private long critically_Number;

    private long deathNumber;

    private String eventTrend;

    private long eventEnlargement;

    private long ambulanceNumber;

    private long doctorNumber;

    private long nurserNumber;

    private long driverNumber;

    private String otherWays;

    private String consultation;

    private long reinforce;

    private String additionalResources;

    private long createUser;

    public MedicalRescue convertForMedicalRescue() {
        MedicalRescueDToConvert convert = new MedicalRescueDToConvert();
        MedicalRescue medicalRescue = convert.doForward(this);
        medicalRescue.setCreateDatetime(new Date());
        return medicalRescue;
    }

    public MedicalRescueForm convertToMedicalRescueForm(MedicalRescue medicalRescue) {
        MedicalRescueDToConvert convert = new MedicalRescueDToConvert();
        MedicalRescueForm medicalRescueForm = convert.doBackward(medicalRescue);
        return medicalRescueForm;
    }

    private static class MedicalRescueDToConvert extends Converter<MedicalRescueForm, MedicalRescue> {

        @Override
        protected MedicalRescue doForward(MedicalRescueForm medicalRescueForm) {
            MedicalRescue medicalRescue = new MedicalRescue();
            BeanUtils.copyProperties(medicalRescueForm, medicalRescue);
            return medicalRescue;
        }

        @Override
        protected MedicalRescueForm doBackward(MedicalRescue medicalRescue) {
            MedicalRescueForm medicalRescueForm = new MedicalRescueForm();
            BeanUtils.copyProperties(medicalRescue, medicalRescueForm);
            return medicalRescueForm;
        }
    }
}
