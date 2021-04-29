package com.victoria.wallet.service.impl;

import com.victoria.wallet.entity.WalletItem;
import com.victoria.wallet.repository.WalletItemRepository;
import com.victoria.wallet.service.WalletItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletItemServiceImpl implements WalletItemService {

    @Autowired
    WalletItemRepository repository;

    @Override
    public WalletItem save(WalletItem wi) {
        return repository.save(wi);
    }
}
