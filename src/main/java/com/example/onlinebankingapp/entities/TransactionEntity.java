package com.example.onlinebankingapp.entities;

import com.example.onlinebankingapp.enums.AccountStatus;
import com.example.onlinebankingapp.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name ="transactions")
public class TransactionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name="transaction_date_time", nullable = false)
    private Timestamp transactionDateTime;

    @Column(name = "transaction_remark", nullable = false)
    private String transactionRemark;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id")
    private PaymentAccountEntity sender;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private PaymentAccountEntity receiver;

    @PrePersist
    protected void onCreate() {
        transactionDateTime = Timestamp.from(Instant.now());
    }


}
