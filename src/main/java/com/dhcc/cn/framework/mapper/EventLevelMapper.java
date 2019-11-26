package com.dhcc.cn.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.cn.framework.pojo.mysql.EventLevel;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLevelMapper extends BaseMapper<EventLevel> {

    String findEventLeverById(@Param("id") long id);

}
