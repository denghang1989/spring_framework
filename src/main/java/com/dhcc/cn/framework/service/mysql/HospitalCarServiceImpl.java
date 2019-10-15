package com.dhcc.cn.framework.service.mysql;

import com.dhcc.cn.framework.dto.HospitalCarForm;
import com.dhcc.cn.framework.dto.emergency.HospitalCarData;
import com.dhcc.cn.framework.mapper.HospitalCarMapper;
import com.dhcc.cn.framework.pojo.mysql.HospitalCar;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Emergency 急诊科数据
 * 24小时院前出车人次
 * 高压氧科
 */
@Service
public class HospitalCarServiceImpl {

    @Autowired
    HospitalCarMapper mHospitalCarMapper;

    /**
     * @param date
     * @return
     * @desc 24小时院前出车人次
     */
    public HospitalCarData getHospitalCar(String date) {
        return new HospitalCarData();
    }

    public int save(HospitalCarForm form) {
        HospitalCar car = new HospitalCar() {{
            setCreateDate(new Date());
        }};
        BeanUtils.copyProperties(form, car);
        return mHospitalCarMapper.insert(car);
    }

}
