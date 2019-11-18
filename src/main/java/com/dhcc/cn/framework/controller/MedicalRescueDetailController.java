package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.MedicalRescueDetailForm;
import com.dhcc.cn.framework.dto.result.Result;
import com.dhcc.cn.framework.dto.result.ResultStatus;
import com.dhcc.cn.framework.pojo.mysql.MedicalRescueDetail;
import com.dhcc.cn.framework.service.mysql.MedicalRescueDetailServiceImpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

/**
 * @author denghang
 * @version V1.0
 * @Package com.dhcc.cn.framework.controller
 * @Description: 这个都是不挣钱的活，搞起来也索然无味
 * @date 2019/11/17 22
 */
@Controller
@Slf4j
public class MedicalRescueDetailController {

    @Autowired
    MedicalRescueDetailServiceImpl mService;

    @PostMapping("/save")
    @ResponseBody
    @ResponseResultBody
    public long insert(MedicalRescueDetailForm form){
        return mService.insert(form);
    }

    @GetMapping("/remove/{id}")
    @ResponseResultBody
    @ResponseBody
    public long deleteById(@PathVariable("id") long id){
        return mService.delete(id);
    }

    @GetMapping("/remove/mainId/{mainId}")
    @ResponseResultBody
    @ResponseBody
    public long deleteByMainId(@PathVariable("mainId") long mainId){
        return mService.deleteByMainId(mainId);
    }

    @GetMapping("/get/{id}")
    @ResponseResultBody
    @ResponseBody
    public MedicalRescueDetailForm queryById(@PathVariable("id") Long id){
        return mService.getMedicalRescueDetailId(id);
    }

    @GetMapping("/get/mainId/{mainId}")
    @ResponseResultBody
    @ResponseBody
    public List<MedicalRescueDetailForm> queryByMainId(@PathVariable("mainId") String mainId){
        return mService.getAllByMainId(mainId);
    }

    @GetMapping("/get/paadmId/{paadmId}")
    @ResponseResultBody
    @ResponseBody
    public Result<MedicalRescueDetailForm> queryByPaadmId(@PathVariable("paadmId") String paadmId){
        Optional<MedicalRescueDetail> optional = mService.getMedicalRescueDetailByEposideId(paadmId);
        return optional.map(medicalRescueDetail -> {
            MedicalRescueDetailForm form = new MedicalRescueDetailForm();
            BeanUtils.copyProperties(medicalRescueDetail, form);
            return Result.success(form);
        }).orElse(Result.error(ResultStatus.DATA_ERROR));
    }

}