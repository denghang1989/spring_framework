package com.dhcc.cn.framework.service.mysql;

import com.dhcc.cn.framework.dto.emergency.HospitalCarData;
import com.dhcc.cn.framework.mapper.HospitalCarMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Emergency 急诊科数据
 * 24小时院前出车人次
 * 高压氧科
 */
@Service
public class HospitalCarServiceImpl {

    @Autowired
    HospitalCarMapper mHospitalCarMapper;


    /**
     * @param date
     * @desc 24小时院前出车人次
     * @return
     */
    public HospitalCarData getHospitalCar(String date){
        return new HospitalCarData();
    }

}
