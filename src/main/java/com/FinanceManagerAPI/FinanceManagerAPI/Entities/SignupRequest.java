package com.FinanceManagerAPI.FinanceManagerAPI.Entities;

import lombok.Data;

@Data
public class SignupRequest {
    public String email;
    public String password;
    public String firstname;
    public String lastname;
    public String phone_number;
}
