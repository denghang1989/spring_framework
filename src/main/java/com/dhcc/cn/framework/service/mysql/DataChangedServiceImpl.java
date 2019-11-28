package com.dhcc.cn.framework.service.mysql;

import com.dhcc.cn.framework.mapper.DataChangedMapper;
import com.dhcc.cn.framework.vo.DataChangedVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataChangedServiceImpl {

    @Autowired
    DataChangedMapper mDataChangeMapper;

    public Optional<DataChangedVo> getDataChangedInfo(Long id){
        DataChangedVo dataChangedInfo = mDataChangeMapper.getDataChangedInfo(id);
        return Optional.ofNullable(dataChangedInfo);
    }

}
