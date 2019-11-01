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
import java.util.List;
import java.util.stream.Collectors;

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
    public OxygenData getOxygenData(Date date) {
        OxygenData oxygenData = new OxygenData();
        QueryWrapper<Oxygen> wrapper = new QueryWrapper<>();
        wrapper.eq("date", date);
        Oxygen oxygen = mOxygenMapper.selectOne(wrapper);
        BeanUtils.copyProperties(oxygen, oxygenData);
        return oxygenData;
    }

    public int insert(OxygenForm form) {
        Oxygen oxygen = new Oxygen(){{
            setCreateDate(new Date());
        }};
        BeanUtils.copyProperties(form, oxygen);
        return mOxygenMapper.insert(oxygen);
    }

    public List<OxygenData> getAll(Date start, Date end) {
        QueryWrapper<Oxygen> wrapper = new QueryWrapper<>();
        wrapper.between("date", start, end);
        List<Oxygen> oxygens = mOxygenMapper.selectList(wrapper);
        List<OxygenData> oxygenDataList = oxygens.stream().map(oxygen -> {
            OxygenData oxygenData = new OxygenData();
            BeanUtils.copyProperties(oxygen, oxygenData);
            return oxygenData;
        }).collect(Collectors.toList());
        return oxygenDataList;
    }

    public int update(OxygenForm form) {
        Oxygen oxygen = new Oxygen();
        BeanUtils.copyProperties(form, oxygen);
        int result = mOxygenMapper.updateById(oxygen);
        return result;
    }
}
