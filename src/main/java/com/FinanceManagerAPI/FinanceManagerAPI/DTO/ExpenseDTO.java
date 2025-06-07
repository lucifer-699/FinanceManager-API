package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class ExpenseDTO {
    private String transactionid;
    private String firstname;
    private String lastname;
    private String createDate;
    private String categoryName;
    private String amount;
    private String categoryType;
    private String remarks;


    // Constructor to map the Object[] to the DTO
    public ExpenseDTO(String transactionid,String firstname, String lastname, String createDate,String categoryName, String amount,String categoryType, String remarks) {
        this.transactionid = transactionid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.createDate = createDate;
        this.categoryName = categoryName;
        this.amount = amount;
        this.categoryType = categoryType;
        this.remarks = remarks;
    }
}
