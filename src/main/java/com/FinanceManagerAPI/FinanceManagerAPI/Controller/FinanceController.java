package com.FinanceManagerAPI.FinanceManagerAPI.Controller;

import com.FinanceManagerAPI.FinanceManagerAPI.DTO.*;
import com.FinanceManagerAPI.FinanceManagerAPI.Services.FinanceService;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {
@Autowired
private FinanceService financeService;

    @GetMapping("/dashboard")
    public List<DashboardDTO> dashboard(@RequestParam String userid){
       return financeService.getDashboardDetails(userid);
    }

    @GetMapping("/incometable")
    public List<IncomeDTO> incometable(@RequestParam String userid,@RequestParam String month){
        System.out.println(financeService.incometable(userid, month));
        return financeService.incometable(userid,month);
    }
    @GetMapping("/expensetable")
    public List<ExpenseDTO> expensetable(@RequestParam String userid,@RequestParam String month){
        System.out.println(financeService.expensetable(userid, month));
        return financeService.expensetable(userid,month);
    }

    @GetMapping("/transactiontable")
    public List<TransactionDTO> gettransaction (@RequestParam String userid,@RequestParam String month){
        System.out.println(financeService.gettransaction(userid,month));
        return financeService.gettransaction(userid,month);
    }
    @GetMapping("/planning")
    public List<PlanningDTO> getplanning (@RequestParam String userid){
        System.out.println("Planing List :" +financeService.getplanning(userid) );
        return financeService.getplanning(userid);
    }
    @GetMapping("/incomeExpense")
    public List<AnalyticsDTO> getMonthlyIncomeandExpense (@RequestParam String userid){
        return financeService.getMonthlyIncomeandExpense(userid);
    }
    @GetMapping("/analyticsCategory")
    public List<AnalyticsCategoryDTO> getAnalyticsCategory(@RequestParam String userid){
        System.out.println(financeService.getAnalyticsCategory(userid));
        return financeService.getAnalyticsCategory(userid);

    }
    @GetMapping("/categoryid")
    public List<CategoryIDTO> categoryid(){
        System.out.println(financeService.categoryid());
        return financeService.categoryid();
    }
    @GetMapping("/mapid")
    public List<CategoryMapDTO> categorymapid(@RequestParam String categoryid){
        System.out.println(financeService.categorymapid(categoryid));
        return financeService.categorymapid(categoryid);
    }
    @PostMapping("/insertinex")
    public boolean insert(@RequestParam String userid,
                          @RequestParam String categoryid,
                          @RequestParam String transaction_type,
                          @RequestParam String mapid,
                          @RequestParam String amount,
                          @RequestParam String remarks){
        System.out.println(remarks);

        boolean response = financeService.insertTransaction(userid, categoryid, transaction_type, mapid, amount, remarks);
        System.out.println(response);
        return response;
    }

    @PostMapping("/insertplan")
    public boolean insertplan(@RequestParam String userid,
                          @RequestParam String categoryid,
                          @RequestParam String mapid,
                          @RequestParam String amount){
        boolean response = financeService.insertBudget(userid, categoryid, mapid, amount);
        System.out.println(response);
        return response;
    }

    @PostMapping("/insertcategory")
    public boolean insertcategory(String categoryName, String categoryType){
        boolean response = financeService.insertCategory(categoryName,categoryType);
        System.out.println(response);
        return response;
    }

    @PostMapping("/insertcategoryMapping")
    public boolean insertcategoryMapping(String categoryid, String categoryType,String transactionType){
        boolean response = financeService.insertCategoryMapping(categoryid, categoryType, transactionType);
        System.out.println(response);
        return response;
    }


    @PostMapping("/insertUser")
    public boolean insertUser(String firstname,String lastname, String email,String password,String phone_number){
        boolean response = financeService.insertUser(firstname, lastname, email, password, phone_number);
        System.out.println(response);
        return response;
    }

    @PostMapping("/deleteTransaction")
    public boolean deleteTransaction(@RequestParam String transactionid, @RequestParam String userid) {
        boolean response = financeService.deleteTransaction(transactionid, userid);
        System.out.println("Deleted: " + response);
        return response;
    }


}

