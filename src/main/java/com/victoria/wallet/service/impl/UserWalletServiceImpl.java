package com.victoria.wallet.service.impl;

import com.victoria.wallet.entity.UserWallet;
import com.victoria.wallet.repository.UserWalletRepository;
import com.victoria.wallet.service.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    private UserWalletRepository repository;

    @Override
    public UserWallet save(UserWallet uw) {
        return repository.save(uw);
    }

    @Override
    public Optional<UserWallet> findByUsersIdAndWalletId(Long user, Long wallet) {
        return repository.findByUsersIdAndWalletId(user, wallet);
    }
}
