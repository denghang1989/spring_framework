package com.dhcc.cn.framework.service.cache;

import com.dhcc.cn.framework.dto.emergency.EICUData;
import com.dhcc.cn.framework.dto.emergency.EmergencyData;
import com.dhcc.cn.framework.dto.emergency.EmergencyPatientData;
import com.dhcc.cn.framework.dto.emergency.EmergencyWardData;
import com.dhcc.cn.framework.dto.emergency.InjectData;
import com.dhcc.cn.framework.mapper.EmergencyMapper;
import com.github.abel533.echarts.Option;

import org.checkerframework.checker.nullness.Opt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyServiceImpl {

    @Autowired
    EmergencyMapper mEmergencyMapper;

    public EICUData getEICU(String date) {
        //        EICUData eicuData = mEmergencyMapper.getEICU(date);
        EICUData eicuData = new EICUData();
        return eicuData;
    }

    public EmergencyData getEmergencyData(String date) {
        //        EmergencyData emergencyData = mEmergencyMapper.getEmergencyData(date);
        EmergencyData emergencyData = new EmergencyData();
        return emergencyData;
    }

    public EmergencyPatientData getEmergencyPatient(String date) {
        //        EmergencyPatientData emergencyPatient = mEmergencyMapper.getEmergencyPatient(date);
        EmergencyPatientData emergencyPatient = new EmergencyPatientData();
        return emergencyPatient;
    }


    public InjectData getInjectData(String date) {
        //        InjectData injectData = mEmergencyMapper.getInjectData(date);
        InjectData injectData = new InjectData();
        return injectData;
    }


    public EmergencyWardData getEmergencyWard(String date) {
        //        InjectData injectData = mEmergencyMapper.getInjectData(date);
        EmergencyWardData emergencyWardData = new EmergencyWardData();
        return emergencyWardData;
    }


    public Option getWeekEmergency(String date) {
        Option option = new Option();
        option.title("hehe");
        return option;
    }

    public Option getWeekEmergencyWard(String date) {
        Option option = new Option();
        option.title("xx");
        return option;
    }

    public Option getWeekInject(String date) {
        Option option = new Option();
        option.title("xxx");
        return option;
    }
}
