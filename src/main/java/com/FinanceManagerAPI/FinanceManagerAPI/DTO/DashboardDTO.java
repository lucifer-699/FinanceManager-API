package com.FinanceManagerAPI.FinanceManagerAPI.DTO;
import lombok.Data;
@Data
public class DashboardDTO {
    private String userid;
    private String firstname;
    private String lastname;
    private String totalIncome;
    private String totalExpense;
    private String lastMonthIncome;
    private String lastMonthExpense;
    private String balance;
    private String balancechange;
    private String savings;
    private String incomeChange;
    private String expenseChange;
    private String savingPercent;

    // Constructor to map the Object[] to the DTO
    public DashboardDTO(String userid,
                        String firstname,
                        String lastname,
                        String totalIncome,
                        String totalExpense,
                        String lastMonthIncome,
                        String lastMonthExpense,
                        String balance,
                        String balancechange,
                        String savings,
                        String incomePercent,
                        String expensePercent,
                        String savingPercent) {
       this.userid = userid;
       this.firstname = firstname;
       this.lastname = lastname;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense; this.lastMonthIncome = lastMonthIncome;
        this.lastMonthExpense = lastMonthExpense;
        this.balance = balance;
        this.balancechange = balancechange;
        this.savings = savings;
        this.incomeChange = incomePercent;
        this.expenseChange = expensePercent;
        this.savingPercent = savingPercent;
    }
}
