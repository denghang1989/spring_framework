package com.dhcc.cn.framework.service.mysql;

import com.dhcc.cn.framework.dto.emergency.OxygenData;
import com.dhcc.cn.framework.mapper.OxygenMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Emergency 急诊科数据
 * 高压氧科
 */
@Service
public class OxygenServiceImpl {

    @Autowired
    OxygenMapper mOxygenMapper;


    /**
     * @param date
     * @return
     * @desc 高压氧科
     */
    public OxygenData getOxygenData(String date) {
        return new OxygenData();
    }

}
