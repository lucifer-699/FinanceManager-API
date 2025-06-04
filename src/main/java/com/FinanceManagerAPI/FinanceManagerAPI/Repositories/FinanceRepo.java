package com.FinanceManagerAPI.FinanceManagerAPI.Repositories;
import com.FinanceManagerAPI.FinanceManagerAPI.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FinanceRepo extends JpaRepository<UserEntity,String> {

    @Query(value = "SELECT * FROM getdashboarddetails(:userid)", nativeQuery = true)
    List<Object[]> getRawDashboardData(String userid);

    @Query(value = "SELECT * FROM get_income_transactions_text(:userid, :month);", nativeQuery = true)
    List<Object[]> getIncomeRaw(String userid, String month);

    @Query(value = "SELECT * FROM get_expense_transactions_text(:userid,:month);", nativeQuery = true)
    List<Object[]> getExpenseRaw(String userid, String month);

    @Query(value = "select * from public.get_transactions_text(:userid, :month)",nativeQuery = true)
    List<Object[]> gettransaction(String userid,
                                  String month);

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

    @Query(value = "SELECT insert_transaction(:userid, :categoryid, :transaction_type, :mapid, :amount, :remarks)", nativeQuery = true)
    List<Object[]> insertTransaction(
            @Param("userid") String userid,
            @Param("categoryid") String categoryid,
            @Param("transaction_type") String transactionType,
            @Param("mapid") String mapid,
            @Param("amount") String amount,
            @Param("remarks") String remarks
    );


    @Query(value = "SELECT insert_budget(:userid, :categoryid,:mapid, :amount);",nativeQuery = true)
    List<Object[]> insertBudget(  @Param("userid") String userid,
                                  @Param("categoryid") String categoryid,
                                  @Param("mapid") String mapid,
                                  @Param("amount") String amount
    );

    @Query(value = "SELECT insert_category(:categoryName, :categoryType);",nativeQuery = true)
    List<Object[]> insertCategory(  @Param("categoryName") String categoryName,
                                  @Param("categoryType") String categoryType);

    @Query(value = "SELECT insert_categorymapping(:categoryid, :categoryType, :transactionType);",nativeQuery = true)
    List<Object[]> insertCategoryMapping(   @Param("categoryid") String categoryid,
                                           @Param("categoryType") String categoryType,
                                            @Param("transactionType") String transactionType);


    @Query(value = "SELECT insert_user(:firstname, :lastname, :email, :password, :phone_number);", nativeQuery = true)
    List<Object[]> insertUser(
            @Param("firstname") String firstname,
            @Param("lastname") String lastname,
            @Param("email") String email,
            @Param("password") String password,
            @Param("phone_number") String phoneNumber
    );
    @Query(value = "SELECT delete_transaction(:transactionid, :userid);",nativeQuery = true)
    List<Object[]> DeleteTransaction(  @Param("transactionid") String transactionid,
                                    @Param("userid") String userid);


}

