package com.FinanceManagerAPI.FinanceManagerAPI.Controller;

import com.FinanceManagerAPI.FinanceManagerAPI.DTO.*;
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
    public List<DashboardDTO> dashboard(String userid){
       return financeService.getDashboardDetails(userid);
    }

    @GetMapping("/incometable")
    public List<IncomeDTO> incometable(String userid){

        return financeService.incometable(userid);
    }
    @GetMapping("/expensetable")
    public List<ExpenseDTO> expensetable(String userid){
        return financeService.expensetable(userid);
    }

    @GetMapping("/transactiontable")
    public List<TransactionDTO> gettransaction (String userid){
        return financeService.gettransaction(userid);
    }
    @GetMapping("/planning")
    public List<PlanningDTO> getplanning (String userid){
        return financeService.getplanning(userid);
    }
}
