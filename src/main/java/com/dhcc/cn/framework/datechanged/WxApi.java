package com.dhcc.cn.framework.datechanged;

import com.dhcc.cn.framework.dto.wxapi.Token;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WxApi {
    //https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
    @GET("/cgi-bin/token")
    Call<Token> getToken(@Query("grant_type") String grant_type, @Query("appid") String appid ,@Query("secret") String secret);

}
