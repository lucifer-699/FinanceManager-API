package com.FinanceManagerAPI.FinanceManagerAPI.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name ="users")
public class UserEntity {
    @Id
    private String userid;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

}
