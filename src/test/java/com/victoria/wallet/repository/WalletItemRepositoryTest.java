package com.victoria.wallet.repository;

import com.victoria.wallet.entity.Wallet;
import com.victoria.wallet.entity.WalletItem;
import com.victoria.wallet.util.enums.TypeEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletItemRepositoryTest {

    private static final Date DATE = new Date();
    private static final String DESCRIPTION ="Conta de luz";
    private static final TypeEnum TYPE = TypeEnum.EN;
    private static final BigDecimal VALUE = BigDecimal.valueOf(65);

    @Autowired
    WalletItemRepository repository;

    @Autowired
    WalletRepository walletRepository;

    @Test
    public void testSave() {
        Wallet w = new Wallet();
        w.setName("Carteira 1");
        w.setValue(BigDecimal.valueOf(500));
        walletRepository.save(w);
        WalletItem wi = new WalletItem(1L, w, DATE, TYPE, DESCRIPTION, VALUE);

        WalletItem response = repository.save(wi);

        assertNotNull(response);
        assertEquals(response.getDescription(), DESCRIPTION);
        assertEquals(response.getType(), TYPE);
        assertEquals(response.getValue(), VALUE);
        assertEquals(response.getWallet().getId(), w.getId());

    }

}
