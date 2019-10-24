package com.dhcc.cn.framework.service.mysql;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dhcc.cn.framework.dto.HospitalCarForm;
import com.dhcc.cn.framework.dto.emergency.HospitalCarData;
import com.dhcc.cn.framework.mapper.HospitalCarMapper;
import com.dhcc.cn.framework.pojo.mysql.HospitalCar;
import com.github.abel533.echarts.Option;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
        HospitalCarData hospitalCarData = null;
        QueryWrapper<HospitalCar> wrapper = new QueryWrapper<>();
        wrapper.eq("date", date);
        HospitalCar car = mHospitalCarMapper.selectOne(wrapper);
        if (car != null) {
            hospitalCarData = new HospitalCarData();
            copyData(car, hospitalCarData);
        }
        return hospitalCarData;
    }

    /**
     * @param form
     * @return
     */
    public int save(HospitalCarForm form) {
        HospitalCar car = new HospitalCar() {{
            setCreateDate(new Date(System.currentTimeMillis()));
        }};
        BeanUtils.copyProperties(form, car);
        return mHospitalCarMapper.insert(car);
    }

    /**
     * @param startDate
     * @param endDate
     * @return
     * @desc 获取一段时间的数据
     */
    public List<HospitalCarData> getAll(String startDate, String endDate) {
        QueryWrapper<HospitalCar> wrapper = new QueryWrapper<>();
        wrapper.between("date", startDate, endDate);
        List<HospitalCar> hospitalCars = mHospitalCarMapper.selectList(wrapper);
        List<HospitalCarData> hospitalCarData = hospitalCars.stream().map(car -> {
            HospitalCarData data = new HospitalCarData();
            copyData(car, data);
            return data;
        }).collect(Collectors.toList());
        return hospitalCarData;
    }

    private void copyData(HospitalCar car, HospitalCarData data) {
        data.setItem8(car.getItem1() + car.getItem2() + car.getItem3() + car.getItem4() + car.getItem5() + car.getItem6() + car.getItem7());
        BeanUtils.copyProperties(car, data);
    }

    public Option getWeekHospitalCar(String date) {
        Option option = new Option();
        return option;
    }
}
