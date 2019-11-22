package com.dhcc.cn.framework.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dhcc.cn.framework.pojo.mysql.MedicalRescue;
import com.dhcc.cn.framework.vo.MedicalRescueVo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface MedicalRescueMapper extends BaseMapper<MedicalRescue> {

    List<MedicalRescueVo> findByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
