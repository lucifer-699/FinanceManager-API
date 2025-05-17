package com.FinanceManagerAPI.FinanceManagerAPI.Controller;

import com.FinanceManagerAPI.FinanceManagerAPI.DTO.DashboardDTO;
import com.FinanceManagerAPI.FinanceManagerAPI.DTO.IncomeDTO;
import com.FinanceManagerAPI.FinanceManagerAPI.Services.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {
@Autowired
private FinanceService financeService;

    @GetMapping("/dashboard")
    public List<DashboardDTO> dashboard(){
       return financeService.getDashboardDetails();
    }

    @GetMapping("/incometable")
    public List<IncomeDTO> incometable(){

        return financeService.incometable();
    }
}
