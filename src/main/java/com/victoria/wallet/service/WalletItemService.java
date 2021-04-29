package com.victoria.wallet.service;

import com.victoria.wallet.entity.WalletItem;
import com.victoria.wallet.util.enums.TypeEnum;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface WalletItemService {

    WalletItem save(WalletItem i);

    Page<WalletItem> findBetweenDates(Long wallet, Date start, Date end, int page);

    List<WalletItem> findByWalletAndType(Long wallet, TypeEnum typeEnum);

    BigDecimal sumByWalletId(Long wallet);
}
