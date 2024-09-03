package com.complexapi.aitools.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.complexapi.aitools.Entity.BeneficiaryPeople;
import com.complexapi.aitools.Entity.MoneyTransaction;
import com.complexapi.aitools.Entity.Person;
import com.complexapi.aitools.Entity.Transfer;
import com.complexapi.aitools.Repo.MoneyTransactionRepo;
import com.complexapi.aitools.Repo.PersonRepo;
import com.complexapi.aitools.Repo.ReceivingRepo;
import com.complexapi.aitools.Repo.TransferRepo;

@Service
public class MoneyService {

@Autowired
private MoneyTransactionRepo moneyTransactionRepo;
@Autowired
private PersonRepo personRepo;
@Autowired
private ReceivingRepo receivingRepo;
@Autowired
private TransferRepo transferRepo;
    public String inserting(MoneyTransaction moneyTransaction) {
        String transactionType=moneyTransaction.getTransactionType();
        Long requestId=moneyTransaction.getPersonId();
        Person person=personRepo.findById(requestId).orElse(null);
        if(transactionType.equals("deposit")){
            //accountbalance badh jayega
            double existingBalance=person.getAccountBalance();
            double newBalance=existingBalance+moneyTransaction.getTransactionAmount();
            person.setAccountBalance(newBalance);

        }
        else if(transactionType.equals("withdraw")||transactionType.equals("transfer")){
            //accountBalance kam ho jayega 
            double existingBalance=person.getAccountBalance();
            if(existingBalance>=moneyTransaction.getTransactionAmount()){
            double newBalance=existingBalance-moneyTransaction.getTransactionAmount();
            person.setAccountBalance(newBalance);
            if(transactionType.equals("transfer")){
            List<BeneficiaryPeople> existingBeneficiaryPeople=receivingRepo.findAll();
            if(existingBeneficiaryPeople.isEmpty()){
                throw new IllegalArgumentException("No beneficiary people found");
            }

            Transfer transfer=new Transfer();
            System.out.println("yaha tak");
            transfer.setTransferredToWhom(existingBeneficiaryPeople.get(0).getReceivingPersonName());
            System.out.println("se yaha tak");
            transfer.setTotalTransferMoney(moneyTransaction.getTransactionAmount());
            transfer.setTransferMode("UPI");
            transfer.setPersonId(requestId);
            transferRepo.save(transfer);
            }
            }
            else{
                throw new IllegalArgumentException("cann't withdraw the amount ");
            }
        }

        this.moneyTransactionRepo.save(moneyTransaction);
        
        return "tranasction uploaded in my Db";
    
    }


}
