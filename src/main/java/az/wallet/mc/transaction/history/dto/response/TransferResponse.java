package az.wallet.mc.transaction.history.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferResponse {
    private UUID senderTransactionId;
    private UUID recipientTransactionId;
}
