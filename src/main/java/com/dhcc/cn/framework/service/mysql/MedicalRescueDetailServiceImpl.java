package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.dhcc.cn.framework.dto.MedicalRescueDetailForm;
import com.dhcc.cn.framework.mapper.MedicalRescueDetailMapper;
import com.dhcc.cn.framework.pojo.mysql.MedicalRescueDetail;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

/**
 * @author denghang
 * @version V1.0
 * @Package com.dhcc.cn.framework.service.mysql
 * @Description: (用一句话描述该文件做什么)
 * @date 2019/11/17 21
 */
@Service
@Slf4j
public class MedicalRescueDetailServiceImpl {

    @Autowired
    MedicalRescueDetailMapper mMapper;

    public List<MedicalRescueDetailForm> getAllByMainId(String mainId) {
        LambdaQueryWrapper<MedicalRescueDetail> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(MedicalRescueDetail::getMainId, mainId);
        List<MedicalRescueDetailForm> medicalRescueDetailForms = mMapper.selectList(wrapper).stream().map(medicalRescueDetail -> {
            MedicalRescueDetailForm form = getMedicalRescueDetailForm(medicalRescueDetail);
            return form;
        }).collect(Collectors.toList());
        return medicalRescueDetailForms;
    }

    public MedicalRescueDetailForm getMedicalRescueDetailId(long id) {
        MedicalRescueDetail medicalRescueDetail = mMapper.selectById(id);
        MedicalRescueDetailForm form = getMedicalRescueDetailForm(medicalRescueDetail);
        return form;
    }


    public Optional<MedicalRescueDetail> getMedicalRescueDetailByEposideId(String eposideId){
        LambdaQueryWrapper<MedicalRescueDetail> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(MedicalRescueDetail::getPaadmId,eposideId);
        MedicalRescueDetail medicalRescueDetail = mMapper.selectOne(queryWrapper);
        Optional<MedicalRescueDetail> optional = Optional.ofNullable(medicalRescueDetail);
        return optional;
    }

    private MedicalRescueDetailForm getMedicalRescueDetailForm(MedicalRescueDetail medicalRescueDetail) {
        MedicalRescueDetailForm form = new MedicalRescueDetailForm();
        BeanUtils.copyProperties(medicalRescueDetail, form);
        return form;
    }

    public Long insert(MedicalRescueDetailForm medicalRescueDetailForm) {
        MedicalRescueDetail medicalRescueDetail = new MedicalRescueDetail();
        BeanUtils.copyProperties(medicalRescueDetailForm, medicalRescueDetail);
        int insert = mMapper.insert(medicalRescueDetail);
        return medicalRescueDetail.getId();
    }

    public int update(MedicalRescueDetailForm medicalRescueDetailForm) {
        MedicalRescueDetail medicalRescueDetail = new MedicalRescueDetail();
        BeanUtils.copyProperties(medicalRescueDetailForm, medicalRescueDetail);
        int update = mMapper.updateById(medicalRescueDetail);
        return update;
    }

    public int delete(long id) {
        int deleteById = mMapper.deleteById(id);
        return deleteById;
    }

    public int deleteByMainId(long mainId) {
        Map<String, Object> map = new HashMap<>();
        map.put("main_id", mainId);
        int deleteByMap = mMapper.deleteByMap(map);
        return deleteByMap;
    }

}
