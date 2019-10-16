package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.HospitalCarForm;
import com.dhcc.cn.framework.dto.emergency.HospitalCarData;
import com.dhcc.cn.framework.service.mysql.HospitalCarServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Emergency 急诊科数据
 * 24小时院前出车人次
 */
@RestController
@RequestMapping("/HospitalCar")
public class HospitalCarController {

    @Autowired
    HospitalCarServiceImpl mHCService;

    @GetMapping("/date")
    @ResponseResultBody
    public HospitalCarData getHospitalCar(String date){
        return mHCService.getHospitalCar(date);
    }

    @PostMapping("/save")
    @ResponseResultBody
    public int save(@Validated HospitalCarForm form){
        return mHCService.save(form);
    }

    @GetMapping("/all")
    @ResponseResultBody
    public List<HospitalCarData> getAllByDate(String start,String end){
        return mHCService.getAll(start, end);
    }

}
