package com.FinanceManagerAPI.FinanceManagerAPI.Repositories;
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
}

