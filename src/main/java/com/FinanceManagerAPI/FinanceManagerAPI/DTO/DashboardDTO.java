package com.FinanceManagerAPI.FinanceManagerAPI.DTO;
import lombok.Data;
@Data
public class DashboardDTO {
    private String totalIncome;
    private String totalExpense;
    private String balance;
    private String balancechange;
    private String lastMonthIncome;
    private String lastMonthExpense;
    private String savings;
    private String incomeChange;
    private String expenseChange;
    private String savingPercent;

    // Constructor to map the Object[] to the DTO
    public DashboardDTO(String totalIncome, String totalExpense, String balance,String balancechange,
                        String lastMonthIncome, String lastMonthExpense, String savings,
                        String incomePercent, String expensePercent, String savingPercent) {
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.balance = balance;
        this.balancechange = balancechange;
        this.lastMonthIncome = lastMonthIncome;
        this.lastMonthExpense = lastMonthExpense;
        this.savings = savings;
        this.incomeChange = incomePercent;
        this.expenseChange = expensePercent;
        this.savingPercent = savingPercent;
    }
}
