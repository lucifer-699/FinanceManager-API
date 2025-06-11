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
    List<Object[]> getRawDashboardData(int userid);

    @Query(value = "SELECT * FROM get_income_transactions_text(:userid, :month);", nativeQuery = true)
    List<Object[]> getIncomeRaw(int userid, String month);

    @Query(value = "SELECT * FROM get_expense_transactions_text(:userid,:month);", nativeQuery = true)
    List<Object[]> getExpenseRaw(int userid, String month);

    @Query(value = "select * from public.get_transactions_text(:userid, :month)",nativeQuery = true)
    List<Object[]> gettransaction(int userid,
                                  String month);

    @Query(value = "SELECT * FROM public.get_budget_summary_text(:userid);",nativeQuery = true)
    List<Object[]> getplanning (int userid);

    @Query(value = "SELECT * FROM public.get_monthly_income_expense_summary(:userid);",nativeQuery = true)
    List<Object[]> getMonthlyIncomeandExpense (int userid);

    @Query(value = "SELECT * FROM public.get_analytics_summary_text(:userid);",nativeQuery = true)
    List<Object[]> getAnalyticsCategory (int userid);

    @Query(value = "SELECT * FROM public.getcategory (:userid);",nativeQuery = true)
    List<Object[]> getcategoryid(@Param("userid") int userid);

    @Query(value = "SELECT * FROM public.get_category_mapping (:categoryid , :userid);",nativeQuery = true)
    List<Object[]> getmappingid(int categoryid, int userid);

    @Query(value = "SELECT insert_transaction(:userid, :categoryid, :transaction_type, :mapid, :amount, :remarks)", nativeQuery = true)
    List<Object[]> insertTransaction(
            @Param("userid") int userid,
            @Param("categoryid") int categoryid,
            @Param("transaction_type") String transactionType,
            @Param("mapid") int mapid,
            @Param("amount") String amount,
            @Param("remarks") String remarks
    );


    @Query(value = "SELECT insert_budget(:userid, :categoryid,:mapid, :amount);",nativeQuery = true)
    List<Object[]> insertBudget(  @Param("userid") int userid,
                                  @Param("categoryid") int categoryid,
                                  @Param("mapid") int mapid,
                                  @Param("amount") String amount
    );

    @Query(value = "SELECT insert_category(:categoryName, :categoryType,:userid);",nativeQuery = true)
    List<Object[]> insertCategory(  @Param("categoryName") String categoryName,
                                    @Param("categoryType") String categoryType,
                                    @Param("userid") int userid
                                  );

    @Query(value = "SELECT insert_categorymapping(:categoryid, :categoryType, :transactionType, :userid);",nativeQuery = true)
    List<Object[]> insertCategoryMapping(   @Param("categoryid") int categoryid,
                                           @Param("categoryType") String categoryType,
                                            @Param("transactionType") String transactionType,
                                            @Param("userid") int userid);


//    @Query(value = "SELECT insert_user(:firstname, :lastname, :email, :password, :phone_number);", nativeQuery = true)
//    List<Object[]> insertUser(
//            @Param("firstname") String firstname,
//            @Param("lastname") String lastname,
//            @Param("email") String email,
//            @Param("password") String password,
//            @Param("phone_number") String phoneNumber
//    );
    @Query(value = "SELECT delete_transaction(:transactionid, :userid);",nativeQuery = true)
    List<Object[]> DeleteTransaction(  @Param("transactionid") int transactionid,
                                    @Param("userid") int userid);

    @Query(value = "SELECT public.delete_categorymapping(:mapid, :userid);",nativeQuery = true)
    List<Object[]> DeleteCategoryMapping(  @Param("mapid") int mapid,
                                       @Param("userid") int userid);

}

