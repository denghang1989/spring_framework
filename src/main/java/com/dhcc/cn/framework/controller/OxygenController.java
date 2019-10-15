package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.dto.emergency.OxygenData;
import com.dhcc.cn.framework.service.mysql.OxygenServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Emergency 急诊科数据
 * 高压氧科
 */
@RestController
public class OxygenController {

    @Autowired
    OxygenServiceImpl mOxygenService;

    @GetMapping("/OxygenData")
    public OxygenData getOxygenData(String date){
        return mOxygenService.getOxygenData(date);
    }

}
