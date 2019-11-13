package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.MedicalRescueForm;
import com.dhcc.cn.framework.service.mysql.MedicalRescueService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;


@RestController
@ResponseResultBody
@RequestMapping("/MedicalRescue")
public class MedicalRescueController {

    @Autowired
    MedicalRescueService mService;

    @PostMapping("/save")
    public int insert(MedicalRescueForm form){
        return mService.insert(form);
    }

    @GetMapping("/get")
    public MedicalRescueForm getMedicalRescueById(int id){
        return mService.selectById(id);
    }

    @GetMapping("/date")
    public List<MedicalRescueForm> getMedicalRescueByDate(Date date){
        return mService.selectByDate(date);
    }
}
