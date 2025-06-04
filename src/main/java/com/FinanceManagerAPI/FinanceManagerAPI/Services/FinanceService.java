package com.FinanceManagerAPI.FinanceManagerAPI.Services;

import com.FinanceManagerAPI.FinanceManagerAPI.DTO.*;
import com.FinanceManagerAPI.FinanceManagerAPI.Repositories.FinanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FinanceService {

    @Autowired
    private FinanceRepo financeRepo;


    public List<DashboardDTO> getDashboardDetails(String userid) {
        List<Object[]> rawData = financeRepo.getRawDashboardData(userid);

        // Map each row of the Object[] to a DashboardDTO
        List<DashboardDTO> result = rawData.stream() .filter(row -> row.length >= 13).map(row -> new DashboardDTO(
                (String) row[0],//userid
                (String) row[1],  // totalIncome
                (String) row[2], // totalExpense
                (String) row[3],// balance
                (String) row[4],  //balanceChange
                (String) row[5], // lastMonthIncome
                (String) row[6], // lastMonthExpense
                (String) row[7], // savings
                (String) row[8],// incomePercent
                (String) row[9] , // expensePercent
                (String) row[10],
                (String) row[11],
                (String) row[12]// savingPercent
        )).collect(Collectors.toList());

        return result;
    }

    public List<IncomeDTO>incometable(String userid,String month){
        List<Object[]> rawData = financeRepo.getIncomeRaw(userid, month);

        List<IncomeDTO> result = financeRepo.getIncomeRaw(userid,month)
                .stream()
                .map(row -> new IncomeDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (String) row[4],
                        (String) row[5],
                        (String) row[6],
                        (String) row[7]))
                .collect(Collectors.toList());
        return result;
    }

    public List<ExpenseDTO>expensetable(String userid,String month){
        List<Object[]> rawData = financeRepo.getExpenseRaw(userid,month);

        List<ExpenseDTO> result = financeRepo.getExpenseRaw(userid,month)
                .stream()
                .map(row -> new ExpenseDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (String) row[4],
                        (String) row[5],
                        (String) row[6],
                        (String) row[7]))
                .collect(Collectors.toList());

        return result;
    }

    public List<TransactionDTO>gettransaction(String userid,String month){
       // List<Object[]> rawData = financeRepo.gettransaction(userid);

        List<TransactionDTO> result = financeRepo.gettransaction(userid,month)
                .stream()
                .map(row -> new TransactionDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (String) row[4]))
                .collect(Collectors.toList());

        return result;
    }

    public List<PlanningDTO>getplanning(String userid){
        List<Object[]> rawData = financeRepo.getplanning(userid);

        List<PlanningDTO> result = financeRepo.getplanning(userid)
                .stream()
                .map(row -> new PlanningDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (String) row[4],
                        (String) row[5],
                        (String) row[6]))
                .collect(Collectors.toList());

        return result;
    }

    public List<AnalyticsDTO>getMonthlyIncomeandExpense(String userid){
        List<Object[]> rawData = financeRepo.getMonthlyIncomeandExpense(userid);

        List<AnalyticsDTO> result = financeRepo.getMonthlyIncomeandExpense(userid)
                .stream()
                .map(row -> new AnalyticsDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2]))
                .collect(Collectors.toList());

        return result;
    }

    public List<AnalyticsCategoryDTO>getAnalyticsCategory(String userid){
        List<Object[]> rawData = financeRepo.getAnalyticsCategory(userid);

        List<AnalyticsCategoryDTO> result = financeRepo.getAnalyticsCategory(userid)
                .stream()
                .map(row -> new AnalyticsCategoryDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3],
                        (String) row[4],
                        (String) row[5]))
                .collect(Collectors.toList());

        return result;
    }

    public List<CategoryIDTO> categoryid (){
        List<Object[]> rawData = financeRepo.categoryid();

        List<CategoryIDTO> result = financeRepo.categoryid()
                .stream()
                .map(row -> new CategoryIDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2]))
                .collect(Collectors.toList());

        return result;
    }

    public List<CategoryMapDTO> categorymapid (String categoryid){
        List<Object[]> rawData = financeRepo.mappingid(categoryid);

        List<CategoryMapDTO> result = financeRepo.mappingid(categoryid)
                .stream()
                .map(row -> new CategoryMapDTO(
                        (String) row[0],
                        (String) row[1],
                        (String) row[2],
                        (String) row[3]))
                .collect(Collectors.toList());

        return result;
    }

    public boolean insertTransaction(String userid, String categoryid, String transaction_type, String mapid, String amount,String remarks) {
        try {
            List<Object[]> rawData = financeRepo.insertTransaction(userid, categoryid, transaction_type, mapid, amount, remarks);
            if (rawData != null && !rawData.isEmpty()) {
                String result = (String) rawData.get(0)[0];
                return "1".equals(result); // return true if result is "1"
            }
        } catch (Exception e) {
            // Optionally log the exception
            e.printStackTrace();
        }
        return false; // return false on error or invalid result
    }
    public boolean insertBudget (String userid, String categoryid, String mapid, String amount){
        try {
            List<Object[]> rawData = financeRepo.insertBudget(userid, categoryid, mapid, amount);
            if (rawData != null && !rawData.isEmpty()) {
                String result = (String) rawData.get(0)[0];
                return "1".equals(result); // return true if result is "1"
            }
        } catch (Exception e) {
            // Optionally log the exception
            e.printStackTrace();
        }
        return false; // return false on error or invalid result
    }

    public boolean insertCategory (String categoryName, String categoryType){
        try {
            List<Object[]> rawData = financeRepo.insertCategory(categoryName, categoryType);
            if (rawData != null && !rawData.isEmpty()) {
                String result = (String) rawData.get(0)[0];
                return "1".equals(result); // return true if result is "1"
            }
        } catch (Exception e) {
            // Optionally log the exception
            e.printStackTrace();
        }
        return false; // return false on error or invalid result
    }


    public boolean insertCategoryMapping (String categoryid, String categoryType,String transactionType){
        try {
            List<Object[]> rawData = financeRepo.insertCategoryMapping(categoryid, categoryType,transactionType);
            if (rawData != null && !rawData.isEmpty()) {
                String result = (String) rawData.get(0)[0];
                return "1".equals(result); // return true if result is "1"
            }
        } catch (Exception e) {
            // Optionally log the exception
            e.printStackTrace();
        }
        return false; // return false on error or invalid result
    }


    public boolean insertUser (String firstname,String lastname, String email,String password,String phone_number){
        try {
            List<Object[]> rawData = financeRepo.insertUser(firstname,lastname,email,password,phone_number);
            if (rawData != null && !rawData.isEmpty()) {
                String result = (String) rawData.get(0)[0];
                return "1".equals(result); // return true if result is "1"
            }
        } catch (Exception e) {
            // Optionally log the exception
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteTransaction(String transactionid, String userid) {
        try {
            List<Object[]> rawData = financeRepo.DeleteTransaction(transactionid, userid);
            if (rawData != null && !rawData.isEmpty()) {
                Object resultObj = rawData.get(0)[0];
                if (resultObj instanceof Number) {
                    int result = ((Number) resultObj).intValue();
                    return result == 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // or use logger
        }
        return false;
    }
}
