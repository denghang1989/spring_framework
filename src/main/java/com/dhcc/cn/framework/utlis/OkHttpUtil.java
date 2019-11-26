package com.dhcc.cn.framework.utlis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import okhttp3.OkHttpClient;

@Configuration
public class OkHttpUtil {

    @Bean
    public OkHttpClient createOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();
        return okHttpClient;
    }

}
