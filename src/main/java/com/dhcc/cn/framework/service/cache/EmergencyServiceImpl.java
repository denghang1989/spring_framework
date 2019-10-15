package com.dhcc.cn.framework.service.cache;

import com.dhcc.cn.framework.dto.emergency.EICUData;
import com.dhcc.cn.framework.dto.emergency.EmergencyData;
import com.dhcc.cn.framework.dto.emergency.EmergencyPatientData;
import com.dhcc.cn.framework.dto.emergency.InjectData;
import com.dhcc.cn.framework.mapper.EmergencyMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyServiceImpl {

    @Autowired
    EmergencyMapper mEmergencyMapper;

    public EICUData getEICU(String date){
        return new EICUData();
    }

    public EmergencyData getEmergencyData(String date){
        EmergencyData emergencyData = mEmergencyMapper.getEmergencyData(date);
        return emergencyData;
    }

    public EmergencyPatientData getEmergencyPatient(String date){
        return new EmergencyPatientData();
    }


    public InjectData getInjectData(String date){
        return new InjectData();
    }


}
