package az.wallet.mc.transaction.history.controller;

import az.wallet.mc.transaction.history.dto.request.TransactionSaveRequest;
import az.wallet.mc.transaction.history.dto.response.TransactionSaveResponse;
import az.wallet.mc.transaction.history.service.TransactionHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
