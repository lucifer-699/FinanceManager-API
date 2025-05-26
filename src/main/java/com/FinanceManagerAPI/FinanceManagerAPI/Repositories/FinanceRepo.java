package com.FinanceManagerAPI.FinanceManagerAPI.Repositories;
import com.FinanceManagerAPI.FinanceManagerAPI.DTO.InsertResponseDTO;
import com.FinanceManagerAPI.FinanceManagerAPI.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FinanceRepo extends JpaRepository<UserEntity,String> {

    @Query(value = "SELECT * FROM getdashboarddetails(:userid)", nativeQuery = true)
    List<Object[]> getRawDashboardData(String userid);

    @Query(value = "SELECT * FROM get_income_transactions_text(:userid);", nativeQuery = true)
    List<Object[]> getIncomeRaw(String userid);

    @Query(value = "SELECT * FROM get_expense_transactions_text(:userid);", nativeQuery = true)
    List<Object[]> getExpenseRaw(String userid);

    @Query(value = "select * from public.get_transactions_text(:userid)",nativeQuery = true)
    List<Object[]> gettransaction(String userid);

    @Query(value = "SELECT * FROM public.get_budget_summary_text(:userid);",nativeQuery = true)
    List<Object[]> getplanning (String userid);

    @Query(value = "SELECT * FROM public.get_monthly_income_expense_summary(:userid);",nativeQuery = true)
    List<Object[]> getMonthlyIncomeandExpense (String userid);

    @Query(value = "SELECT * FROM public.get_analytics_summary_text(:userid);",nativeQuery = true)
    List<Object[]> getAnalyticsCategory (String userid);

    @Query(value = "select * from categories;",nativeQuery = true)
    List<Object[]>  categoryid();

    @Query(value = "select * from categorymapping where categoryid = :categoryid",nativeQuery = true)
    List<Object[]>  mappingid(String categoryid);

    @Query(value = "SELECT insert_transaction(:userid, :categoryid, :transaction_type, :mapid, :amount);",nativeQuery = true)
    InsertResponseDTO insertTransaction(String userid, String categoryid, String transaction_type, String mapid, String amount);
}

