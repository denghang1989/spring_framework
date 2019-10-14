package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.pojo.CtLoc;
import com.dhcc.cn.framework.service.impl.CtLocServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/loc")
public class CtLocController {

    @Autowired
    CtLocServiceImpl mService;

    @GetMapping("/ctloc")
    @ResponseResultBody
    public List<CtLoc> login(String type) {
        return mService.getCtLoc(type);
    }

    @GetMapping("/{id}")
    public CtLoc getCtLoc(@PathVariable("id") int id){
        return mService.getById(id);
    }
}