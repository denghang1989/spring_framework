package com.dhcc.cn.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.cn.framework.pojo.cache.CtLoc;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtLocMapper extends BaseMapper<CtLoc> {

    List<CtLoc> getAllCtLoc(@Param("type") String type);

    CtLoc getCtLoc(@Param("id") int id);

}
