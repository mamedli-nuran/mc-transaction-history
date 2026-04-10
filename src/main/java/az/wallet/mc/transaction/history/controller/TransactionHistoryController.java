package az.wallet.mc.transaction.history.controller;

import az.wallet.mc.transaction.history.dto.request.TransactionSaveRequest;
import az.wallet.mc.transaction.history.dto.request.TransferRequest;
import az.wallet.mc.transaction.history.dto.response.TransactionResponse;
import az.wallet.mc.transaction.history.dto.response.TransactionSaveResponse;
import az.wallet.mc.transaction.history.dto.response.TransferResponse;
import az.wallet.mc.transaction.history.service.TransactionHistoryService;
import jakarta.servlet.ServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transaction-history")
public class TransactionHistoryController {
    private final TransactionHistoryService transactionHistoryService;

    @PostMapping("/save")
    public ResponseEntity<TransactionSaveResponse> saveTransactionInHistory(@RequestBody TransactionSaveRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transactionHistoryService.save(request));
    }

    @GetMapping("/wallet/{walletId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsInWallet(@PathVariable UUID walletId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionHistoryService.getWalletHistory(walletId));
    }


    @PostMapping("transfer")
    public ResponseEntity<TransferResponse> saveTransferInHistory(@RequestBody TransferRequest transferRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(transactionHistoryService.saveTransfer(transferRequest));
    }
}
