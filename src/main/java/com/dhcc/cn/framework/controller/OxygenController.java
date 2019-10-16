package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.OxygenForm;
import com.dhcc.cn.framework.dto.emergency.OxygenData;
import com.dhcc.cn.framework.service.mysql.OxygenServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Emergency 急诊科数据
 * 高压氧科
 */
@RestController
@RequestMapping("Oxygen")
public class OxygenController {

    @Autowired
    OxygenServiceImpl mOxygenService;

    @GetMapping("/date")
    @ResponseResultBody
    public OxygenData getOxygenData(String date){
        return mOxygenService.getOxygenData(date);
    }

    @PostMapping("/save")
    @ResponseResultBody
    public int save(@Validated OxygenForm form){
        return mOxygenService.save(form);
    }

    @GetMapping("/all")
    @ResponseResultBody
    public List<OxygenData> getAllByDate(String start,String end){
        return mOxygenService.getAll(start,end);
    }

}
