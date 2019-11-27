package com.dhcc.cn.framework.dto.wxapi;

import lombok.Data;

@Data
public class Token {

    /**
     * access_token : ACCESS_TOKEN
     * expires_in : 7200
     */

    private String access_token;
    private int expires_in;

}
