package com.complexapi.aitools.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Entity;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoryTransaction {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long historyTransactionId;
    private double totalAmountWithdraw;
    private double totalAmountDeposit;
    private int countAmountWithdraw;
    private int countAmountDeposit;
    private Long personId;
    
}
