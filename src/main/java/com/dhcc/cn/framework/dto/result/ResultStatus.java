package com.dhcc.cn.framework.dto.result;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ResultStatus {
    SUCCESS(HttpStatus.OK, 0, "成功"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, 400, "参数异常"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "服务器异常");

    /**
     * 返回的HTTP状态码,  符合http请求
     */
    private HttpStatus httpStatus;
    /**
     * 业务异常码
     */
    private Integer    code;
    /**
     * 业务异常信息描述
     */
    private String     message;

    ResultStatus(HttpStatus httpStatus, Integer code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
