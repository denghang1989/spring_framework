package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.HospitalCarForm;
import com.dhcc.cn.framework.dto.emergency.HospitalCarData;
import com.dhcc.cn.framework.service.mysql.HospitalCarServiceImpl;
import com.github.abel533.echarts.Option;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Emergency 急诊科数据
 * 24小时院前出车人次
 */
@RestController
@RequestMapping("/HospitalCar")
@ResponseResultBody
public class HospitalCarController {

    @Autowired
    HospitalCarServiceImpl mHCService;

    @GetMapping("/date")
    public HospitalCarData getHospitalCar(Date date) {
        return mHCService.getHospitalCar(date);
    }

    @PostMapping("/save")
    public int insert(@Validated HospitalCarForm form) {
        return mHCService.insert(form);
    }

    @PostMapping("/update")
    public int update(@Validated HospitalCarForm form) {
        return mHCService.update(form);
    }

    @GetMapping("/all")
    public List<HospitalCarData> getAllByDate(Date start, Date end) {
        return mHCService.getAll(start, end);
    }

    @GetMapping("/weekHospitalCar/{date}")
    public Option getWeekHospitalCar(@PathVariable String date) {
        return mHCService.getWeekHospitalCar(date);
    }

}
