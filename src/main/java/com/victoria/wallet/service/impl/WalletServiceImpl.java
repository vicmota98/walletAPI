package com.victoria.wallet.service.impl;

import com.victoria.wallet.entity.Wallet;
import com.victoria.wallet.repository.WalletRepository;
import com.victoria.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository repository;

    @Override
    public Wallet save(Wallet w) {
        return repository.save(w);
    }
}
