package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.dto.MedicalRescueDetailForm;
import com.dhcc.cn.framework.dto.result.DataGridResult;
import com.dhcc.cn.framework.dto.result.Result;
import com.dhcc.cn.framework.dto.result.ResultStatus;
import com.dhcc.cn.framework.pojo.mysql.MedicalRescueDetail;
import com.dhcc.cn.framework.service.mysql.MedicalRescueDetailServiceImpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/MedicalRescueDetail")
public class MedicalRescueDetailController {

    @Autowired
    MedicalRescueDetailServiceImpl mService;

    @GetMapping("/rescue/detail")
    public String medicalRescueDetail(@RequestParam String rescueId,String detailId, Model model){

        MedicalRescueDetailForm detailForm;
        if(StringUtils.isEmpty(detailId)){
            detailForm=new MedicalRescueDetailForm();
            detailForm.setMainId(Long.valueOf(rescueId));
        }else{
            detailForm=queryById(Long.valueOf(detailId));
        }
        model.addAttribute("detail",detailForm);

        return "rescue/detail";
    }

    @PostMapping("/save")
    @ResponseBody
    @ResponseResultBody
    public long insert(MedicalRescueDetailForm form){
        return mService.insert(form);
    }

    @PostMapping("/update")
    @ResponseBody
    @ResponseResultBody
    public long update(MedicalRescueDetailForm form){
        return mService.update(form);
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

    @GetMapping("/get/dataGrid")
    @ResponseBody
    public DataGridResult queryByMainIdDataGrid(@RequestParam String mainId){
        List<MedicalRescueDetailForm> list = mService.getAllByMainId(mainId);
        return new DataGridResult(list.size(),list);
    }

}
