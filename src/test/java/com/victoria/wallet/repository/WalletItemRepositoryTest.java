package com.victoria.wallet.repository;

import com.victoria.wallet.entity.Wallet;
import com.victoria.wallet.entity.WalletItem;
import com.victoria.wallet.util.enums.TypeEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletItemRepositoryTest {

    private static final Date DATE = new Date();
    private static final String DESCRIPTION ="Conta de luz";
    private static final TypeEnum TYPE = TypeEnum.EN;
    private static final BigDecimal VALUE = BigDecimal.valueOf(65);
    private Long savedWalletItemId = null;
    private Long savedWalletId = null;

    @Autowired
    WalletItemRepository repository;

    @Autowired
    WalletRepository walletRepository;

//    @Before
//    public void setUp() {
//        Wallet w = new Wallet();
//        w.setName("Carteira Teste");
//        w.setValue(BigDecimal.valueOf(250));
//        walletRepository.save(w);
//
//        WalletItem wi = new WalletItem(null, w, DATE, TYPE, DESCRIPTION, VALUE);
//        repository.save(wi);
//
//        savedWalletItemId = wi.getId();
//        savedWalletId = w.getId();
//    }
//
//    @After
//    public void tearDown() {
//        repository.deleteAll();
//        walletRepository.deleteAll();
//    }

    @Test
    public void testSaveWalletItem() {
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

    @Test(expected = ConstraintViolationException.class)
    public void testSaveInvalidWalletItem() {
        WalletItem wi = new WalletItem(null,null, DATE, null, DESCRIPTION,null);
        repository.save(wi);
    }

    @Test
    public void testUpdate() {
        Optional<WalletItem> wi = repository.findById(savedWalletItemId);

        String description = "Descrição alterada";

        WalletItem changed = wi.get();
        changed.setDescription(description);

        repository.save(changed);

        Optional<WalletItem> newWalletItem = repository.findById(savedWalletItemId);

        assertEquals(description, newWalletItem.get().getDescription());
    }

    @Test
    public void deleteWalletItem() {
        Optional<Wallet> wallet = walletRepository.findById(savedWalletId);
        WalletItem wi = new WalletItem(null, wallet.get(), DATE, TYPE, DESCRIPTION, VALUE);

        repository.save(wi);

        repository.deleteById(wi.getId());

        Optional<WalletItem> response = repository.findById(wi.getId());

        assertFalse(response.isPresent());
    }
}
