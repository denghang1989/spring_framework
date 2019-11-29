package com.dhcc.cn.framework.config;

import com.dhcc.cn.framework.datechanged.WxApi;
import com.dhcc.cn.framework.dto.wxapi.Token;
import com.dhcc.cn.framework.utlis.Setting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Configuration
@Slf4j
public class ScheduleTaskConfig {

    @Autowired
    WxApi mWxApi;

    @Autowired
    WxMpDefaultConfigImpl mStorage;

    @Value("${wx.mp.app-id}")
    private String appId;

    @Value("${wx.mp.secret}")
    private String appSecret;


    @Scheduled(fixedDelay = 3600000)
    public void task() {
        Call<Token> call = mWxApi.getToken("client_credential", appId, appSecret);
        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                Token body = response.body();
                log.info(body.getAccess_token());
                mStorage.setAccessToken(body.getAccess_token());
            }

            @Override
            public void onFailure(Call<Token> call, Throwable throwable) {
                log.info(throwable.getMessage());
            }
        });

    }
}
