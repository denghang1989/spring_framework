package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.service.cache.EICUServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/eicu")
public class EICUController {

    @Autowired
    EICUServiceImpl mService;

    @GetMapping("/{date}")
    public int getEicuByDate(@PathVariable String date){
        return mService.getEicuByDate(date);
    }
}
