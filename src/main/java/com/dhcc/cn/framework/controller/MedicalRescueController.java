package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.MedicalRescueForm;
import com.dhcc.cn.framework.dto.result.DataGridResult;
import com.dhcc.cn.framework.service.mysql.MedicalRescueServiceImpl;
import com.dhcc.cn.framework.vo.MedicalRescueVo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/MedicalRescue")
public class MedicalRescueController {

    @Autowired
    MedicalRescueServiceImpl mService;

    @GetMapping("/rescue/index")
    public String medicalRescue(@RequestParam String userId, String rescueId, Model model){
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

    @GetMapping("/rescue/dataList")
    public String medicalRescueList(@RequestParam String userId, Model model){
        model.addAttribute("userId",userId);
        return "rescue/dataList";
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

    @GetMapping("/dateGrid")
    @ResponseBody
    public DataGridResult getMedicalRescueDataGridByDates(Date startDate, Date endDate){
        List<MedicalRescueForm> list = mService.getMedicalRescueListByDates(startDate,endDate);
        return new DataGridResult<MedicalRescueForm>(list.size(),list);
    }

    @GetMapping("/remove/{id}")
    @ResponseResultBody
    @ResponseBody
    public long deleteById(@PathVariable("id") long id){
        return mService.delete(id);
    }

    @GetMapping("/reportDate")
    @ResponseResultBody
    @ResponseBody
    public List<MedicalRescueVo> getListByDates(Date startDate, Date endDate) {
        List<MedicalRescueVo> medicalRescueVos = mService.getListByDates(startDate, endDate);
        return medicalRescueVos;
    }

}
