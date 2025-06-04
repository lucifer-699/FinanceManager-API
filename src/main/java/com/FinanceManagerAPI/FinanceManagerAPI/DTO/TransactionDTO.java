package com.FinanceManagerAPI.FinanceManagerAPI.DTO;

import lombok.Data;

@Data
public class TransactionDTO {
    private String createdate;
    private String category_name;
    private String transactiontype;
    private String amount;
    private String typed;

    public TransactionDTO(String createdate,String category_name, String transactiontype,String amount,String typed) {
        this.createdate = createdate;
        this.category_name = category_name;
        this.transactiontype = transactiontype;
        this.amount = amount;
        this.typed = typed;
    }
}
