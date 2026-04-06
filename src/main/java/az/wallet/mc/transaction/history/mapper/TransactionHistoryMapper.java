package az.wallet.mc.transaction.history.mapper;

import az.wallet.mc.transaction.history.domain.TransactionHistory;
import az.wallet.mc.transaction.history.dto.request.TransactionSaveRequest;
import az.wallet.mc.transaction.history.dto.response.TransactionSaveResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionHistoryMapper {

    public TransactionHistory saveTransactionInHistory(TransactionSaveRequest request) {
        return TransactionHistory.builder()
                .walletId(request.getWalletId())
                .type(request.getType())
                .amount(request.getAmount())
                .provider(request.getProvider())
                .status(request.getStatus())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public TransactionSaveResponse createSavedTransactionResponse(TransactionHistory transactionHistory) {
        return TransactionSaveResponse.builder()
                .transactionId(transactionHistory.getId())
                .createdAt(transactionHistory.getCreatedAt())
                .build();
    }
}
