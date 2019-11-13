package com.dhcc.cn.framework.controller;

import com.dhcc.cn.framework.annotation.ResponseResultBody;
import com.dhcc.cn.framework.mapper.EventLeverMapper;
import com.dhcc.cn.framework.mapper.EventTypeMapper;
import com.dhcc.cn.framework.pojo.mysql.EventLever;
import com.dhcc.cn.framework.pojo.mysql.EventType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseResultBody
@RequestMapping("event")
public class MedicalEvent {

    @Autowired
    EventLeverMapper mEventLeverMapper;

    @Autowired
    EventTypeMapper mEventTypeMapper;

    @GetMapping("/all/lever")
    public List<EventLever> getAllEventLever(){
        return mEventLeverMapper.selectList(null);
    }

    @GetMapping("/all/type")
    public List<EventType> getAllEventType(){
        return mEventTypeMapper.selectList(null);
    }
}
