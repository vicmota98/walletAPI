package com.victoria.wallet.service;
import com.victoria.wallet.entity.UserWallet;

import java.util.Optional;

public interface UserWalletService {

    UserWallet save(UserWallet uw);

    Optional<UserWallet> findByUsersIdAndWalletId(Long user, Long wallet);
}
