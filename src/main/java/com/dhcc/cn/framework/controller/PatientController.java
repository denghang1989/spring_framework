package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.pojo.cache.PatientInfo;
import com.dhcc.cn.framework.service.cache.PatientServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseResultBody
@RequestMapping("/patient")
public class PatientController {
    
    @Autowired
    PatientServiceImpl mService;

    /**
     * @param patientId pa_patmas_id
     * @return
     */
    @GetMapping("/id/{patientId}")
    PatientInfo getPatientById(@PathVariable("patientId") String patientId) {
        return mService.getPatientById(patientId);
    }

    /**
     * @param regNo 住院号
     * @return
     */
    @GetMapping("/regNo/{regNo}")
    PatientInfo getPatientByRegNo(@PathVariable("regNo")String regNo) {
        return mService.getPatientByRegNo(regNo);
    }


    /**
     * @param eposideId 就诊流水号
     * @return
     */
    @GetMapping("/eposideId/{eposideId}")
    PatientInfo getPatientByEposideId(@PathVariable("eposideId")String eposideId) {
        return mService.getPatientByEposideId(eposideId);
    }

    /**
     * @param PAPMINo 登记号
     * @return
     */
    @GetMapping("/PAPMINo/{PAPMINo}")
    PatientInfo getPatientByPAPMINo(@PathVariable("PAPMINo") String PAPMINo) {
        return mService.getPatientByPAPMINo(PAPMINo);
    }
}
