package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhcc.cn.framework.dto.OxygenForm;
import com.dhcc.cn.framework.dto.emergency.OxygenData;
import com.dhcc.cn.framework.mapper.OxygenMapper;
import com.dhcc.cn.framework.pojo.mysql.Oxygen;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Emergency 急诊科数据
 * 高压氧科
 */
@Service
public class OxygenServiceImpl  {

    @Autowired
    OxygenMapper mOxygenMapper;

    /**
     * @param date
     * @return
     * @desc 高压氧科
     */
    public OxygenData getOxygenData(String date) {
        OxygenData oxygenData = new OxygenData();
        QueryWrapper<Oxygen> wrapper = new QueryWrapper<>();
        wrapper.eq("date",date);
        Oxygen oxygen = mOxygenMapper.selectOne(wrapper);
        BeanUtils.copyProperties(oxygen,oxygenData);
        return oxygenData;
    }

    public int save(OxygenForm form){
        Oxygen oxygen = new Oxygen(){{
            setDate(new Date());
        }};
        BeanUtils.copyProperties(form,oxygen);
        return mOxygenMapper.insert(oxygen);
    }

}
