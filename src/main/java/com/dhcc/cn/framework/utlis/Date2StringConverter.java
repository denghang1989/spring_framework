package com.dhcc.cn.framework.utlis;


import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Date2StringConverter implements Converter<Date, String> {

    @Override
    public String convert(Date date) {
        return DateFormatUtils.format(date,"yyyy-MM-dd hh:mm:ss");
    }


}
