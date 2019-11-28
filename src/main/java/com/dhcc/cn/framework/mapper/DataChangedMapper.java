package com.dhcc.cn.framework.mapper;

import com.dhcc.cn.framework.vo.DataChangedVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DataChangedMapper {

    DataChangedVo getDataChangedInfo(@Param("id") Long id);
}
