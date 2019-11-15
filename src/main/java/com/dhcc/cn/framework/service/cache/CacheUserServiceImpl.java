package com.dhcc.cn.framework.service.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhcc.cn.framework.mapper.CacheUserMapper;
import com.dhcc.cn.framework.mapper.PatientMapper;
import com.dhcc.cn.framework.pojo.cache.CacheUser;
import com.dhcc.cn.framework.pojo.cache.PatientInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CacheUserServiceImpl {

    @Autowired
    CacheUserMapper mMapper;

    public CacheUser getCacheUserById(String id){
        QueryWrapper<CacheUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().select(CacheUser.class,tableFieldInfo -> true).eq(CacheUser::getId,id);
        return mMapper.selectOne(wrapper);
    }

    public List<CacheUser> getCacheUserByName(String name){
        QueryWrapper<CacheUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().select(CacheUser.class,tableFieldInfo -> true).like(CacheUser::getName,name);
        return mMapper.selectList(wrapper);
    }

    public List<CacheUser> getCacheUserByCode(String code){
        QueryWrapper<CacheUser> wrapper = new QueryWrapper<>();
        wrapper.lambda().select(CacheUser.class,tableFieldInfo -> true).eq(CacheUser::getCode,code);
        return mMapper.selectList(wrapper);
    }

    public List<CacheUser> getCacheUser(){
        return mMapper.selectList(null);
    }
}
