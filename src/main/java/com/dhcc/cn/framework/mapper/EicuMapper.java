package com.dhcc.cn.framework.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface EicuMapper {

    int getEicuByDate(String date);


}
