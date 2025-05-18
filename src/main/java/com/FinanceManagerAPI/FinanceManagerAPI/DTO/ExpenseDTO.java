package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class ExpenseDTO {
    private String firstname;
    private String lastname;
    private String createDate;
    private String categoryName;
    private String amount;
    private String categoryType;


    // Constructor to map the Object[] to the DTO
    public ExpenseDTO(String firstname, String lastname, String createDate,String categoryName, String amount,String categoryType) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.createDate = createDate;
        this.categoryName = categoryName;
        this.amount = amount;
        this.categoryType = categoryType;
    }
}
