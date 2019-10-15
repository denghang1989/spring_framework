package com.dhcc.cn.framework.mapper;

import com.dhcc.cn.framework.dto.emergency.EICUData;
import com.dhcc.cn.framework.dto.emergency.EmergencyData;
import com.dhcc.cn.framework.dto.emergency.EmergencyPatientData;
import com.dhcc.cn.framework.dto.emergency.InjectData;

import org.springframework.stereotype.Repository;

@Repository
public interface EmergencyMapper {

    EmergencyData getEmergencyData(String date);

    EICUData getEICU(String date);

    EmergencyPatientData getEmergencyPatient(String date);

    InjectData getInjectData(String date);
}
