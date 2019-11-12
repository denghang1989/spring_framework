package com.dhcc.cn.framework.service.cache;

import com.dhcc.cn.framework.mapper.DiagnosTypeMapper;
import com.dhcc.cn.framework.pojo.cache.DiagnosType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosTypeServiceImpl {

    @Autowired
    DiagnosTypeMapper mTypeMapper;

    public List<DiagnosType> getAll() {
        return mTypeMapper.selectList(null);
    }
}
