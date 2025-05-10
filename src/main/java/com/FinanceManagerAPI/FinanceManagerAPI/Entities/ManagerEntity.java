package com.FinanceManagerAPI.FinanceManagerAPI.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class ManagerEntity {
    @Id
    public String ma;
}
