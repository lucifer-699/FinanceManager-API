package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class CategoryIDTO {
    private String categoryid;
    private String category_name;
    private String category_type;

    // Constructor to map the Object[] to the DTO
    public CategoryIDTO(String categoryid,String category_name, String category_type){
        this.categoryid = categoryid;
        this.category_name = category_name;
        this.category_type = category_type;
    }
}
