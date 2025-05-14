package com.FinanceManagerAPI.FinanceManagerAPI.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.boot.query.HbmResultSetMappingDescriptor;

@Data
@Entity
public class DashboardEntity {

    @Id
    @Column(name = "totalIncome")
    private String totalIncome;

    @Column(name = "totalExpense")
    private String totalExpense;

    @Column (name = "balance")
    private String balance;

    @Column (name = "lastMonthIncome")
    private String lastMonthIncome;

    @Column (name = "lastMonthExpense")
    private String lastMonthExpense;

    @Column(name = "Savings")
    private String Savings;

}
