package az.wallet.mc.transaction.history.repository;

import az.wallet.mc.transaction.history.domain.TransactionHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionHistoryRepository extends JpaRepository<TransactionHistory, UUID> {
    List<TransactionHistory> findAllByWalletIdOrderByCreatedAtDesc(UUID walletId);
}
