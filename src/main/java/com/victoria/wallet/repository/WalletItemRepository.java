package com.victoria.wallet.repository;

import com.victoria.wallet.entity.WalletItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletItemRepository extends JpaRepository<WalletItem, Long> {
}
