package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dhcc.cn.framework.annotation.DataChanged;
import com.dhcc.cn.framework.dto.MedicalRescueForm;
import com.dhcc.cn.framework.enums.TopicEmum;
import com.dhcc.cn.framework.mapper.MedicalRescueMapper;
import com.dhcc.cn.framework.pojo.mysql.MedicalRescue;
import com.dhcc.cn.framework.vo.MedicalRescueVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MedicalRescueServiceImpl {

    @Autowired
    MedicalRescueMapper mMapper;

    @DataChanged(value = TopicEmum.INSERT,topic = "MedicalRescue")
    public Long insert(MedicalRescueForm medicalRescueForm){
        MedicalRescue medicalRescue = medicalRescueForm.convertForMedicalRescue();
        int insert = mMapper.insert(medicalRescue);
        return medicalRescue.getId();
    }

    @DataChanged(value = TopicEmum.UPDATE,topic = "MedicalRescue")
    public long update(MedicalRescueForm medicalRescueForm){
        MedicalRescue medicalRescue = medicalRescueForm.convertForMedicalRescue();
        int update = mMapper.updateById(medicalRescue);
        return medicalRescue.getId();
    }

    public MedicalRescueForm selectById(int id){
        MedicalRescue medicalRescue = mMapper.selectById(id);
        MedicalRescueForm rescueForm = new MedicalRescueForm();
        rescueForm.convertToMedicalRescueForm(medicalRescue);
        return rescueForm;
    }

    public List<MedicalRescueForm> selectByDate(Date date){
        QueryWrapper<MedicalRescue> medicalRescueQueryWrapper = new QueryWrapper<>();
        medicalRescueQueryWrapper.lambda().eq(MedicalRescue::getCreateDatetime,date);
        List<MedicalRescueForm> list = getMedicalRescueList(medicalRescueQueryWrapper);
        return list;
    }

    public List<MedicalRescueForm> getMedicalRescueListByDates(Date startDate, Date endDate) {
        QueryWrapper<MedicalRescue> medicalRescueQueryWrapper = new QueryWrapper<>();
        medicalRescueQueryWrapper.lambda().ge(MedicalRescue::getCreateDatetime,startDate).le(MedicalRescue::getCreateDatetime,endDate);
        List<MedicalRescueForm> list = getMedicalRescueList(medicalRescueQueryWrapper);
        return list;
    }

    private List<MedicalRescueForm> getMedicalRescueList(QueryWrapper<MedicalRescue> medicalRescueQueryWrapper) {
        List<MedicalRescue> medicalRescues = mMapper.selectList(medicalRescueQueryWrapper);
        return medicalRescues.stream().map(medicalRescue -> {
            MedicalRescueForm form = new MedicalRescueForm();
            BeanUtils.copyProperties(medicalRescue, form);
            return form;
        }).collect(Collectors.toList());
    }

    public int delete(long id) {
        int deleteById = mMapper.deleteById(id);
        return deleteById;
    }

    /**
     * @param startDate
     * @param endDate
     * @param page
     * @param rows
     * @return
     * @desc 分页查询
     */
    public IPage<MedicalRescue> getMedicalRescueList(Date startDate, Date endDate,int page,int rows){
        Page<MedicalRescue> medicalRescuePage = new Page<>(page,rows);
        QueryWrapper<MedicalRescue> medicalRescueQueryWrapper = new QueryWrapper<>();
        medicalRescueQueryWrapper.lambda().ge(MedicalRescue::getCreateDatetime,startDate).le(MedicalRescue::getCreateDatetime,endDate);
        IPage<MedicalRescue> selectPage = mMapper.selectPage(medicalRescuePage, medicalRescueQueryWrapper);
        return selectPage;
    }


    public List<MedicalRescueVo> getListByDates(Date startDate, Date endDate) {
        List<MedicalRescueVo> medicalRescueVos = mMapper.findByDate(startDate, endDate);
        return medicalRescueVos;
    }

}
