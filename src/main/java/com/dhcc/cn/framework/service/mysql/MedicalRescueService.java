package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhcc.cn.framework.dto.MedicalRescueForm;
import com.dhcc.cn.framework.mapper.MedicalRescueMapper;
import com.dhcc.cn.framework.pojo.mysql.MedicalRescue;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicalRescueService {

    @Autowired
    MedicalRescueMapper mMapper;

    public int insert(MedicalRescueForm medicalRescueForm){
        MedicalRescue medicalRescue = new MedicalRescue();
        medicalRescue.setCreateDatetime(new Date());
        BeanUtils.copyProperties(medicalRescueForm,medicalRescue);
        return mMapper.insert(medicalRescue);
    }

    public MedicalRescueForm selectById(int id){
        MedicalRescue medicalRescue = mMapper.selectById(id);
        MedicalRescueForm rescueForm = new MedicalRescueForm();
        BeanUtils.copyProperties(medicalRescue,rescueForm);
        return rescueForm;
    }

    public List<MedicalRescueForm> selectByDate(Date date){
        QueryWrapper<MedicalRescue> medicalRescueQueryWrapper = new QueryWrapper<>();
        medicalRescueQueryWrapper.lambda().eq(MedicalRescue::getCreateDatetime,date);
        List<MedicalRescue> medicalRescues = mMapper.selectList(medicalRescueQueryWrapper);
        List<MedicalRescueForm> list = medicalRescues.stream().map(medicalRescue -> {
            MedicalRescueForm form = new MedicalRescueForm();
            BeanUtils.copyProperties(medicalRescue, form);
            return form;
        }).collect(Collectors.toList());
        return list;
    }
}
