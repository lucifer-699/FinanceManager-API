package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class AnalyticsCategoryDTO {
    private String category_name;
    private String category_type;
    private String alloted;
    private String used;
    private String remaining;
    private String percent_used;

    // Constructor to map the Object[] to the DTO
    public AnalyticsCategoryDTO(String category_name,String category_type,String alloted,String used,String remaining,String percent_used ) {
            this.category_name = category_name;
            this.category_type = category_type;
            this.alloted = alloted;
            this.used = used;
            this.remaining = remaining;
            this.percent_used = percent_used;
    }
}
