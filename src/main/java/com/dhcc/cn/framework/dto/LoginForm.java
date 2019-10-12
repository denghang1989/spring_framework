package com.dhcc.cn.framework.dto;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class LoginForm implements Serializable {

    @NotBlank(message = "用户名不能为空")
    @Length(min = 6,max = 16,message = "用户名长度必须位于6到12之间")
    @Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$",message = "用户名格式不对，必须由数字和字母组成")
    private String name;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6,max = 18,message = "密码至少6位")
    private String psw;

}
