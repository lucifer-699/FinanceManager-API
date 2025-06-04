package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class CategoryMapDTO {
    private String mapid;
    private String categoryid;
    private String categorytype;
    private String transactiontype;

    // Constructor to map the Object[] to the DTO
    public CategoryMapDTO(String mapid,String categoryid, String transactiontype, String categorytype) {
        this.mapid = mapid;
        this.categoryid = categoryid;
        this.categorytype = categorytype;
        this.transactiontype = transactiontype;
    }
}

