package com.xie.request;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserRegisterDto implements Serializable {

    @NotNull(message = "用户名为空")
    private String username;
    @NotNull(message = "密码为空")
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

