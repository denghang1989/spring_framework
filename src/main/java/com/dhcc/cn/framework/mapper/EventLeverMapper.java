package com.dhcc.cn.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.cn.framework.pojo.mysql.EventLever;
import com.dhcc.cn.framework.pojo.mysql.EventType;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLeverMapper extends BaseMapper<EventLever> {

    String findEventLeverById(@Param("id") long id);
}
