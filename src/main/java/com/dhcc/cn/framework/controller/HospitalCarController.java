package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.dto.emergency.HospitalCarData;
import com.dhcc.cn.framework.service.mysql.HospitalCarServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Emergency 急诊科数据
 * 24小时院前出车人次
 */
@RestController
public class HospitalCarController {

    @Autowired
    HospitalCarServiceImpl mHCService;

    @GetMapping("/HospitalCar")
    public HospitalCarData getHospitalCar(String date){
        return mHCService.getHospitalCar(date);
    }
}
