package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class AnalyticsDTO {
    private String year_month;
    private String totalincome;
    private String totalexpense;

    // Constructor to map the Object[] to the DTO
    public AnalyticsDTO(String year_month,String totalincome, String totalexpense){
        this.year_month = year_month;
        this.totalincome = totalincome;
        this.totalexpense = totalexpense;
    }
}
