package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.MedicalRescueForm;
import com.dhcc.cn.framework.service.mysql.MedicalRescueService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;


@Controller
@RequestMapping("/MedicalRescue")
public class MedicalRescueController {

    @Autowired
    MedicalRescueService mService;

    @GetMapping("/rescue/index")
    public String medicalRescue(String userId,String rescueId, Model model){

        MedicalRescueForm rescueForm;
        if(StringUtils.isEmpty(rescueId)){
            rescueForm=new MedicalRescueForm();
        }else{
            rescueForm=getMedicalRescueById(Integer.valueOf(rescueId));
        }
        model.addAttribute("userId",userId);
        model.addAttribute("rescue",rescueForm);

        return "rescue/index";
    }

    @PostMapping("/save")
    @ResponseResultBody
    @ResponseBody
    public Long insert(MedicalRescueForm form){
        return mService.insert(form);
    }

    @GetMapping("/get")
    @ResponseResultBody
    @ResponseBody
    public MedicalRescueForm getMedicalRescueById(int id){
        return mService.selectById(id);
    }

    @GetMapping("/date")
    @ResponseResultBody
    @ResponseBody
    public List<MedicalRescueForm> getMedicalRescueByDate(Date date){
        return mService.selectByDate(date);
    }

    @GetMapping("/dateList")
    @ResponseResultBody
    @ResponseBody
    public List<MedicalRescueForm> getMedicalRescueListByDates(Date startDate, Date endDate){
        return mService.getMedicalRescueListByDates(startDate,endDate);
    }
}
