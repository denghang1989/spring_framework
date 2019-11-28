package com.dhcc.cn.framework.mapper;

import com.dhcc.cn.framework.pojo.cache.EposideInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EposideMapper {

    /**
    * @description:   通过就诊号获取就诊信息
    * @author ljk
    * @date 2019-11-28
    * @param admId 就诊号
    * @return com.dhcc.cn.framework.pojo.cache.EposideInfo
    */
    EposideInfo getEposideInfoByAdmId(@Param("admId") String admId);

    /**
    * @description:   通过登记号获取就诊信息
    * @author ljk
    * @date 2019-11-28
    * @param regNo  登记号
    * @return com.dhcc.cn.framework.pojo.cache.EposideInfo
    */
    EposideInfo getEposideInfoByRegNo(@Param("regNo") String regNo);

    /**
    * @description:  通过病案号获取就诊信息
    * @author ljk
    * @date 2019-11-28
    * @param medCareNo  病案号
    * @return com.dhcc.cn.framework.pojo.cache.EposideInfo
    */
    EposideInfo getEposideInfoByMedCareNo(@Param("medCareNo") String medCareNo);

}
