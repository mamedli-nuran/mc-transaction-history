package az.wallet.mc.transaction.history.domain;


import az.wallet.mc.transaction.history.domain.enums.TransactionStatus;
import az.wallet.mc.transaction.history.domain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
public class TransactionHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "wallet_id")
    private UUID walletId;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TransactionType type;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "provider")
    private String provider;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
