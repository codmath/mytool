package com.complexapi.aitools.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complexapi.aitools.Entity.HistoryTransaction;
import com.complexapi.aitools.Entity.MoneyTransaction;
import com.complexapi.aitools.Repo.HistoryTransactionRepo;
import com.complexapi.aitools.Repo.MoneyTransactionRepo;

@Service
public class HistoryTransactionService {
    @Autowired
    private MoneyTransactionRepo moneyTransactionRepo;
    @Autowired
    private HistoryTransactionRepo historyTransactionRepo;
   

    public HistoryTransaction todohistory(Long personId) {
        double depositMoney=0.0;
        double withdrawMoney=0.0;
        int count_deposit=0;
        int count_withdraw=0;
        Long count_entries=moneyTransactionRepo.count();
        for(Long i=(long) 1; i<=count_entries; i++){
            MoneyTransaction existingMoneyTransaction=moneyTransactionRepo.findById(i).orElse(null);
            if(existingMoneyTransaction.getPersonId()==personId && existingMoneyTransaction.getTransactionType().equals("deposit")){
                count_deposit++;
                depositMoney+=existingMoneyTransaction.getTransactionAmount();
            }
            else if(existingMoneyTransaction.getPersonId()==personId && existingMoneyTransaction.getTransactionType().equals("withdraw")){
                count_withdraw++;
                withdrawMoney+=existingMoneyTransaction.getTransactionAmount();

            }

        }
        HistoryTransaction historyTransaction=new HistoryTransaction();
        historyTransaction.setTotalAmountDeposit(depositMoney);
        historyTransaction.setTotalAmountWithdraw(withdrawMoney);
        historyTransaction.setCountAmountDeposit(count_deposit);
        historyTransaction.setCountAmountWithdraw(count_withdraw);
        historyTransaction.setPersonId(personId);
        historyTransactionRepo.save(historyTransaction);
    
        return historyTransaction;
    }


    public String getAllHistoryTrxn() {
        List<Double> existingAmountDeposit=historyTransactionRepo.findAccountMoney(2);
        int n =existingAmountDeposit.size();
        double countMoney=0.0;

        for(int i=0; i<n; i++){
            countMoney+=existingAmountDeposit.get(i);
            System.out.println(countMoney);

        }
        return "sum of money is fetched correctlty";
    }
 
    

}
