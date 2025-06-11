package com.FinanceManagerAPI.FinanceManagerAPI.Controller;

import com.FinanceManagerAPI.FinanceManagerAPI.DTO.*;
import com.FinanceManagerAPI.FinanceManagerAPI.Services.FinanceService;
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
        System.out.println( "Database Data Fetched for Userid : " + userid);
        System.out.println(">>>>Result : /n" + financeService.getDashboardDetails(userid));
       return financeService.getDashboardDetails(userid);
    }

    @GetMapping("/incometable")
    public List<IncomeDTO> incometable(@RequestParam String userid,@RequestParam String month){
        System.out.println( "Income Data Fetched for Userid : " + userid+ "and of month : " +month);
        System.out.println(">>>>Result : /n" + financeService.incometable(userid, month));
        return financeService.incometable(userid,month);
    }
    @GetMapping("/expensetable")
    public List<ExpenseDTO> expensetable(@RequestParam String userid,@RequestParam String month){
        System.out.println( "Expense Data Fetched for Userid : " + userid+ "and of month : " +month);
        System.out.println(">>>>Result : /n" +financeService.expensetable(userid, month));
        System.out.println(userid);
        return financeService.expensetable(userid,month);
    }

    @GetMapping("/transactiontable")
    public List<TransactionDTO> gettransaction (@RequestParam String userid,@RequestParam String month){
        System.out.println( "Transaction Data Fetched for Userid : " + userid + "and of month : " +month);
        System.out.println(">>>>Result : /n" + financeService.gettransaction(userid,month));
        return financeService.gettransaction(userid,month);
    }
    @GetMapping("/planning")
    public List<PlanningDTO> getplanning (@RequestParam String userid){

        System.out.println( "Planning Data Fetched for Userid : " + userid);
        System.out.println(">>>>Result :" +financeService.getplanning(userid));
        return financeService.getplanning(userid);
    }
    @GetMapping("/incomeExpense")

    public List<AnalyticsDTO> getMonthlyIncomeandExpense (@RequestParam String userid){
        System.out.println( "Analytics Bargraph Income and Expense Data Fetched for Userid : " + userid);
        System.out.println(">>>>Result :" + financeService.getMonthlyIncomeandExpense(userid));
        return financeService.getMonthlyIncomeandExpense(userid);
    }
    @GetMapping("/analyticsCategory")
    public List<AnalyticsCategoryDTO> getAnalyticsCategory(@RequestParam String userid){
        System.out.println( "Ctegory Over and under spending Data Fetched for Userid : " + userid);
        System.out.println(">>>>Result :" + financeService.getAnalyticsCategory(userid));
        return financeService.getAnalyticsCategory(userid);

    }
    @GetMapping("/categoryid")
    public List<CategoryIDTO> categoryid(@RequestParam String userid){
        System.out.println( "Categoryies fetched Fetched for Userid : " + userid);
        System.out.println(">>>>Result :" +financeService.categoryid(userid));
        return financeService.categoryid(userid);
    }
    @GetMapping("/mapid")
    public List<CategoryMapDTO> categorymapid(@RequestParam String categoryid,@RequestParam String userid){
        System.out.println( "Category Mapped Data Fetched for Userid : " + userid);
        System.out.println(">>>>Result :" +financeService.categorymapid(categoryid,userid));
        return financeService.categorymapid(categoryid,userid);
    }
    @PostMapping("/insertinex")
    public boolean insert(@RequestParam String userid,
                          @RequestParam String categoryid,
                          @RequestParam String transaction_type,
                          @RequestParam String mapid,
                          @RequestParam String amount,
                          @RequestParam String remarks){
        System.out.println( "Inserting Income or expense Data for Userid : " + userid);
        System.out.println(">>>Request : {" + userid +","+ categoryid +","+ transaction_type +","+ mapid +","+ amount + ","+ remarks + "}");
        boolean response = financeService.insertTransaction(userid, categoryid, transaction_type, mapid, amount, remarks);
        System.out.println(">>>>Result :" +response);
        return response;
    }

    @PostMapping("/insertplan")
    public boolean insertplan(@RequestParam String userid,
                          @RequestParam String categoryid,
                          @RequestParam String mapid,
                          @RequestParam String amount){
        System.out.println( "Inserting the plan for Userid : " + userid);
        System.out.println(">>>Request : {" + userid +","+ categoryid +","+ mapid +","+ amount + "}");
        boolean response = financeService.insertBudget(userid, categoryid, mapid, amount);
        System.out.println(">>>>Result :"  + response);
        return response;
    }

    @PostMapping("/insertcategory")
    public boolean insertcategory(String categoryName, String categoryType,String userid){
        System.out.println( "Category Inserted by Userid : " + userid);
        System.out.println(">>>Request : " + categoryName + ","+ categoryType);
        boolean response = financeService.insertCategory(categoryName,categoryType,userid);
        System.out.println(">>>>Result :" + response);
        return response;
    }

    @PostMapping("/insertcategoryMapping")
    public boolean insertcategoryMapping(String categoryid, String categoryType,String transactionType,String userid){
        System.out.println("Category Mapping Inserted by User id : " + userid);
        System.out.println(">>>Request : " + categoryid + ","+ categoryType+ ","+ transactionType+ ","+ userid );
        boolean response = financeService.insertCategoryMapping(categoryid, categoryType, transactionType,userid);
        System.out.println(">>>>Result :" +response);
        return response;
    }


//    @PostMapping("/insertUser")
//    public boolean insertUser(String firstname,String lastname, String email,String password,String phone_number){
//        boolean response = financeService.insertUser(firstname, lastname, email, password, phone_number);
//        System.out.println(response);
//        return response;
//    }

    @PostMapping("/deleteTransaction")
    public boolean deleteTransaction(@RequestParam String transactionid, @RequestParam String userid) {
        boolean response = financeService.deleteTransaction(transactionid, userid);
        System.out.println("Deleted: " + response);
        return response;
    }


}

