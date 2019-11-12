package com.dhcc.cn.framework.mapper;

import com.dhcc.cn.framework.pojo.cache.Diagnos;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EposideDiagnos {

    List<Diagnos> getDiagnosByEposideId(@Param("epsodeId") String EposideId);

}
