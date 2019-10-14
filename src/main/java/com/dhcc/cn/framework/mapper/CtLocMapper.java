package com.dhcc.cn.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.cn.framework.pojo.CtLoc;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CtLocMapper extends BaseMapper<CtLoc> {

    List<CtLoc> getAllCtLoc(@Param("type") String type);

    void delete(@Param("id") String id);
}
