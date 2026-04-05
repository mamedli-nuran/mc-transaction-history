package az.wallet.mc.transaction.history.service;

import az.wallet.mc.transaction.history.domain.TransactionHistory;
import az.wallet.mc.transaction.history.dto.request.TransactionSaveRequest;
import az.wallet.mc.transaction.history.dto.response.TransactionSaveResponse;
import az.wallet.mc.transaction.history.mapper.TransactionHistoryMapper;
import az.wallet.mc.transaction.history.repository.TransactionHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionHistoryService {
    private final TransactionHistoryRepository transactionHistoryRepository;
    private final TransactionHistoryMapper transactionHistoryMapper;

    @Transactional
    public TransactionSaveResponse save(TransactionSaveRequest request) {
        TransactionHistory transaction = transactionHistoryMapper.saveTransactionInHistory(request);
        transactionHistoryRepository.save(transaction);
        return transactionHistoryMapper.createSavedTransactionResponse(transaction);
    }

}
