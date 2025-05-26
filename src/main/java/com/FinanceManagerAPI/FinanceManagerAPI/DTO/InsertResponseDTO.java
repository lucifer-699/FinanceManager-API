package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class InsertResponseDTO {
    public String insert_transaction;

    public InsertResponseDTO(String insert_transaction){
        this.insert_transaction = insert_transaction;
    }
}
