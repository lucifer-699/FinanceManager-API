package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class IncomeDTO {
    private String createDate;
    private String categoryName;
    private String amount;
    private String categoryType;


    // Constructor to map the Object[] to the DTO
    public IncomeDTO(String createDate,String categoryName, String amount,String categoryType) {
        this.createDate = createDate;
        this.categoryName = categoryName;
        this.amount = amount;
        this.categoryType = categoryType;
    }
}
