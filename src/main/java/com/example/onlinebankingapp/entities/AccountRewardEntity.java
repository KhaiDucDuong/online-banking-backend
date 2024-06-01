package com.example.onlinebankingapp.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name ="rewards_of_accounts")
public class AccountRewardEntity {
//    @Id
//    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "reward_id", nullable = false)
//    private RewardEntity reward;
//
//    @Id
//    @ManyToOne(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "payment_account_id", nullable = false)
//    private PaymentAccountEntity paymentAccount;

    @EmbeddedId
    private AccountRewardRelationshipKey accountRewardKey;

    @Column(name = "is_valid", nullable = false)
    @Builder.Default
    private boolean isValid = true;

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AccountRewardRelationshipKey implements Serializable {
        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "reward_id", nullable = false)
        private RewardEntity reward;

        @ManyToOne(cascade = CascadeType.DETACH)
        @JoinColumn(name = "payment_account_id", nullable = false)
        private PaymentAccountEntity paymentAccount;
    }
}
