package com.dhcc.cn.framework.service.cache;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dhcc.cn.framework.mapper.CtLocMapper;
import com.dhcc.cn.framework.pojo.CtLoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CtLocServiceImpl extends ServiceImpl<CtLocMapper, CtLoc> {

    @Autowired
    CtLocMapper mCtLocMapper;

    public List<CtLoc> getAllCtLoc(String type){
        List<CtLoc> allCtLoc = mCtLocMapper.getAllCtLoc(type);
        return allCtLoc;
    }

    public CtLoc getCtLoc(int rowId){
        CtLoc ctLoc = mCtLocMapper.getCtLoc(rowId);
        return ctLoc;
    }

}
