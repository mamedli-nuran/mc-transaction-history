package az.wallet.mc.transaction.history.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class TransactionSaveResponse {
    private UUID id;
    private String status;
    private LocalDateTime createdAt;
}
