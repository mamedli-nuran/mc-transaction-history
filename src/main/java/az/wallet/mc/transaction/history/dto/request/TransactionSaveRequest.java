package az.wallet.mc.transaction.history.dto.request;

import az.wallet.mc.transaction.history.domain.enums.TransactionStatus;
import az.wallet.mc.transaction.history.domain.enums.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionSaveRequest {

    @NotBlank(message = "Wallet ID is required")
    private UUID walletId;

    @NotBlank(message = "Transaction type is required")
    private TransactionType type;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;


    private String provider;

    @NotBlank(message = "Status is required")
    private TransactionStatus status;

}
