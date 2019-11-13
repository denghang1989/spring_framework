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

import java.util.Date;
import java.util.List;


/**
 * Emergency 急诊科数据
 * 高压氧科
 */
@RestController
@RequestMapping("Oxygen")
@ResponseResultBody
public class OxygenController {

    @Autowired
    OxygenServiceImpl mOxygenService;

    @GetMapping("/date")
    public OxygenData getOxygenData(Date date) {
        return mOxygenService.getOxygenData(date);
    }

    @PostMapping("/save")
    public int insert(@Validated OxygenForm form) {
        return mOxygenService.insert(form);
    }

    @PostMapping("/update")
    public int update(@Validated OxygenForm form){
        return mOxygenService.update(form);
    }

    @GetMapping("/all")
    public List<OxygenData> getAllByDate(Date start, Date end) {
        return mOxygenService.getAll(start, end);
    }

}
