package com.dhcc.cn.framework.service.cache;

import com.dhcc.cn.framework.mapper.EposideMapper;
import com.dhcc.cn.framework.pojo.cache.EposideInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EposideServiceImpl {

    @Autowired
    EposideMapper mapper;

    /**
     * @description:   通过就诊号获取就诊信息
     * @author ljk
     * @date 2019-11-28
     * @param admId 就诊号
     * @return com.dhcc.cn.framework.pojo.cache.EposideInfo
     */
    public EposideInfo getEposideInfoByAdmId(String admId){
        return mapper.getEposideInfoByAdmId(admId);
    }

    /**
     * @description:   通过登记号获取就诊信息
     * @author ljk
     * @date 2019-11-28
     * @param regNo 登记号
     * @return com.dhcc.cn.framework.pojo.cache.EposideInfo
     */
    public EposideInfo getEposideInfoByRegNo(String regNo){
        return mapper.getEposideInfoByRegNo(regNo);
    }

    /**
     * @description:  通过病案号获取就诊信息
     * @author ljk
     * @date 2019-11-28
     * @param medCareNo  病案号
     * @return com.dhcc.cn.framework.pojo.cache.EposideInfo
     */
    public EposideInfo getEposideInfoByMedCareNo(String medCareNo){
        return mapper.getEposideInfoByMedCareNo(medCareNo);
    }

}
