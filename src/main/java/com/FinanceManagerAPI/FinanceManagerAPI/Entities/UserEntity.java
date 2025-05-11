package com.FinanceManagerAPI.FinanceManagerAPI.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserEntity {
    @Id
    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

}
