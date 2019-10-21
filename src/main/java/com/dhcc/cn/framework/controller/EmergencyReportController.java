package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.emergency.EICUData;
import com.dhcc.cn.framework.dto.emergency.EmergencyData;
import com.dhcc.cn.framework.dto.emergency.EmergencyPatientData;
import com.dhcc.cn.framework.dto.emergency.EmergencyWardData;
import com.dhcc.cn.framework.dto.emergency.InjectData;
import com.dhcc.cn.framework.service.cache.EmergencyServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 急诊科数据
 */
@RestController
@ResponseResultBody
@RequestMapping("/emergency")
public class EmergencyReportController {

    @Autowired
    EmergencyServiceImpl mEmergencyService;

    @GetMapping("/EICUData")
    public EICUData getEICU(String date){
        return mEmergencyService.getEICU(date);
    }

    @GetMapping("/EmergencyData")
    public EmergencyData getEmergencyData(String date){
        return mEmergencyService.getEmergencyData(date);
    }

    @GetMapping("/EmergencyPatientData")
    public EmergencyPatientData getEmergencyPatient(String date){
        return mEmergencyService.getEmergencyPatient(date);
    }

    @GetMapping("/InjectData")
    public InjectData getInjectData(String date){
        return mEmergencyService.getInjectData(date);
    }

    @GetMapping("/EmergencyWardData")
    public EmergencyWardData getEmergencyWard(String date){
        return mEmergencyService.getEmergencyWard(date);
    }


}
