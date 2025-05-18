package com.FinanceManagerAPI.FinanceManagerAPI.Entities;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String userid;
    public LoginResponse ( String token, String userid){
        this.token = token;
        this.userid = userid;
    }
}
