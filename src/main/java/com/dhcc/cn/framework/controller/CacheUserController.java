package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.pojo.cache.CacheUser;
import com.dhcc.cn.framework.service.cache.CacheUserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cacheUser")
@ResponseResultBody
public class CacheUserController {

    @Autowired
    CacheUserServiceImpl mService;

    @GetMapping("/id/{id}")
    public CacheUser getCacheUserById(@PathVariable("id") String id){
        return mService.getCacheUserById(id);
    }

    @GetMapping("/name")
    public List<CacheUser> getCacheUserByName(String name){
        return mService.getCacheUserByName(name);
    }

    @GetMapping("/code/{code}")
    public List<CacheUser> getCacheByCode(@PathVariable("code") String code){
        return mService.getCacheUserByCode(code);
    }

    @GetMapping("/all")
    public List<CacheUser> getCacheUser(){
        return mService.getCacheUser();
    }
}
