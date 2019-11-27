package com.dhcc.cn.framework.config;

import com.dhcc.cn.framework.datechanged.WxApi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class HttpConfig {

    @Value("${wx.baseUrl}")
    private String url;

    @Bean
    public OkHttpClient createOkHttpClient(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .readTimeout(5000,TimeUnit.MILLISECONDS)
                .writeTimeout(5000,TimeUnit.MILLISECONDS)
                .build();
        return okHttpClient;
    }

    @Bean
    public Retrofit createRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(createOkHttpClient())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        return retrofit;
    }

    @Bean
    public WxApi createWxApi(){
        Retrofit retrofit = createRetrofit();
        return retrofit.create(WxApi.class);
    }

}
