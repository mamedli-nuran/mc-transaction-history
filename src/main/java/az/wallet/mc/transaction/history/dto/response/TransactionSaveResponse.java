package az.wallet.mc.transaction.history.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TransactionSaveResponse {
    private UUID transactionId;
    private LocalDateTime createdAt;
}
