package com.dhcc.cn.framework.service.cache;

import com.dhcc.cn.framework.mapper.EicuMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EICUServiceImpl {

    @Autowired
    EicuMapper mEicuMapper;

    public int getEicuByDate(String date){
        return mEicuMapper.getEicuByDate(date);
    }
}
