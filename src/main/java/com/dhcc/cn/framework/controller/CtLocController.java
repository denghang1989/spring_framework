package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.pojo.cache.CtLoc;
import com.dhcc.cn.framework.service.cache.CtLocServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/loc")
@ResponseResultBody
public class CtLocController {

    @Autowired
    CtLocServiceImpl mService;

    @GetMapping("/type")
    public List<CtLoc> getAllCtLoc(String type) {
        return mService.getAllCtLoc(type);
    }

    @GetMapping("/{id}")
    public CtLoc getCtLoc(@PathVariable("id") int id){
        return mService.getCtLoc(id);
    }
}
