package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.pojo.cache.DiagnosType;
import com.dhcc.cn.framework.service.cache.DiagnosTypeServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/DiagnosType")
@ResponseResultBody
public class DiagnosTypeController {

    @Autowired
    DiagnosTypeServiceImpl mDiagnosTypeService;

    @GetMapping("/all")
    public List<DiagnosType> getAll() {
        return mDiagnosTypeService.getAll();
    }
}
