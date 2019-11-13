package com.dhcc.cn.framework.mapper;

import com.dhcc.cn.framework.pojo.cache.PatientInfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientMapper {


    /**
     * @param patientId  pa_patmas_id
     * @return
     */
    PatientInfo getPatientById(@Param("patientId") String patientId);

    /**
     * @param regNo 住院号
     * @return
     */
    PatientInfo getPatientByRegNo(@Param("regNo") String regNo);


    /**
     * @param eposideId 就诊流水号
     * @return
     */
    PatientInfo getPatientByEposideId(@Param("eposideId") String eposideId);

    /**
     * @param PAPMINo 登记号
     * @return
     */
    PatientInfo getPatientByPAPMINo(@Param("PAPMINo")String PAPMINo);
}
