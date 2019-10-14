package com.dhcc.cn.framework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhcc.cn.framework.annotation.DataSourceSwitch;
import com.dhcc.cn.framework.enums.DBTypeEnum;
import com.dhcc.cn.framework.mapper.CtLocMapper;
import com.dhcc.cn.framework.pojo.CtLoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CtLocServiceImpl extends ServiceImpl<CtLocMapper, CtLoc> {

    @Autowired
    CtLocMapper mCtLocMapper;

    @DataSourceSwitch(DBTypeEnum.CACHE)
    public List<CtLoc> getCtLoc(String type){
        List<CtLoc> allCtLoc = mCtLocMapper.getAllCtLoc(type);
        return allCtLoc;
    }

}
