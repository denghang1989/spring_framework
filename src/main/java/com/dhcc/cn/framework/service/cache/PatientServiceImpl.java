package com.dhcc.cn.framework.service.cache;

import com.dhcc.cn.framework.mapper.PatientMapper;
import com.dhcc.cn.framework.pojo.cache.PatientInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl {

    @Autowired
    PatientMapper mMapper;

    /**
     * @param patientId pa_patmas_id
     * @return
     */
    public PatientInfo getPatientById(String patientId) {
        return mMapper.getPatientById(patientId);
    }

    /**
     * @param medCareNo 住院号
     * @return
     */
    public PatientInfo getPatientByMedCareNo(String medCareNo) {
        return mMapper.getPatientByMedCareNo(medCareNo);
    }


    /**
     * @param eposideId 就诊流水号
     * @return
     */
    public PatientInfo getPatientByEposideId(String eposideId) {
        return mMapper.getPatientByEposideId(eposideId);
    }

    /**
     * @param regNo 登记号
     * @return
     */
    public PatientInfo getPatientByRegNo(String regNo) {
        return mMapper.getPatientByRegNo(regNo);
    }
}
