package com.FinanceManagerAPI.FinanceManagerAPI.Repositories;
import com.FinanceManagerAPI.FinanceManagerAPI.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FinanceRepo extends JpaRepository<UserEntity,String> {

    @Query(value = "SELECT * FROM get_dashboard_text_view", nativeQuery = true)
    List<Object[]> getRawDashboardData();

    @Query(value = "SELECT create_date, category_name, amount, category_type FROM income_transactions_text_view", nativeQuery = true)
    List<Object[]> getIncomeRaw();
}

