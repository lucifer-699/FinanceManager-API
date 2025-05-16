package com.FinanceManagerAPI.FinanceManagerAPI.Services;

import com.FinanceManagerAPI.FinanceManagerAPI.DTO.DashboardDTO;
import com.FinanceManagerAPI.FinanceManagerAPI.Repositories.FinanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FinanceService {

    @Autowired
    private FinanceRepo financeRepo;


    public List<DashboardDTO> getDashboardDetails() {
        List<Object[]> rawData = financeRepo.getRawDashboardData();

        // Map each row of the Object[] to a DashboardDTO
        List<DashboardDTO> result = rawData.stream() .filter(row -> row.length >= 10).map(row -> new DashboardDTO(
                (String) row[0], // totalIncome
                (String) row[1], // totalExpense
                (String) row[2], // balance
                (String) row[3], //balanceChange
                (String) row[4], // lastMonthIncome
                (String) row[5], // lastMonthExpense
                (String) row[6], // savings
                (String) row[7], // incomePercent
                (String) row[8], // expensePercent
                (String) row[9]  // savingPercent
        )).collect(Collectors.toList());

        return result;
    }


}
