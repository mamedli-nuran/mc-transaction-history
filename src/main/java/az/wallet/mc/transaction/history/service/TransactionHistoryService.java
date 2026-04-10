package az.wallet.mc.transaction.history.service;

import az.wallet.mc.transaction.history.domain.TransactionHistory;
import az.wallet.mc.transaction.history.domain.enums.TransactionStatus;
import az.wallet.mc.transaction.history.domain.enums.TransactionType;
import az.wallet.mc.transaction.history.dto.request.TransactionSaveRequest;
import az.wallet.mc.transaction.history.dto.request.TransferRequest;
import az.wallet.mc.transaction.history.dto.response.TransactionResponse;
import az.wallet.mc.transaction.history.dto.response.TransactionSaveResponse;
import az.wallet.mc.transaction.history.dto.response.TransferResponse;
import az.wallet.mc.transaction.history.mapper.TransactionHistoryMapper;
import az.wallet.mc.transaction.history.repository.TransactionHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionHistoryService {
    private final TransactionHistoryRepository transactionHistoryRepository;
    private final TransactionHistoryMapper transactionHistoryMapper;


    public TransactionSaveResponse save(TransactionSaveRequest request) {
        TransactionHistory transaction = transactionHistoryMapper.saveTransactionInHistory(request);
        transactionHistoryRepository.save(transaction);
        return transactionHistoryMapper.createSavedTransactionResponse(transaction);
    }

    public List<TransactionResponse> getWalletHistory(UUID walletId){

        List<TransactionHistory> historyOfEntity =
                transactionHistoryRepository.findAllByWalletIdOrderByCreatedAtDesc(walletId);
        return historyOfEntity.stream()
        .map(transactionHistoryMapper::transactionToTransactionResponse)
        .toList();
    }

    public TransferResponse saveTransfer(TransferRequest request){
        TransactionHistory senderTransaction = transactionHistoryRepository.save(
                transactionHistoryMapper.saveTransactionInHistory(TransactionSaveRequest.builder()
                        .walletId(request.getSenderId())
                        .type(TransactionType.TRANSFER_OUT)
                        .amount(request.getAmount().negate())
                        .provider("Transfer to " + request.getReceiverId())
                        .status(TransactionStatus.SUCCESS)
                        .build()));

        TransactionHistory receiverTransaction = transactionHistoryRepository.save(
                transactionHistoryMapper.saveTransactionInHistory(TransactionSaveRequest.builder()
                        .walletId(request.getReceiverId())
                        .type(TransactionType.TRANSFER_IN)
                        .amount(request.getAmount())
                        .provider("Transfer from " + request.getSenderId())
                        .status(TransactionStatus.SUCCESS)
                        .build()));


        return new TransferResponse(senderTransaction.getId(), receiverTransaction.getId());
    }
}
