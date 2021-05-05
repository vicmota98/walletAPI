package com.victoria.wallet.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.victoria.wallet.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "email@tese.com";

    //injetar classe para teste
    @Autowired
    UserRepository repository;

    @Before
    public void setUp() {
        User u = new User();
        u.setName("Set up user");
        u.setPassword("Senha");
        u.setEmail(EMAIL);

        repository.save(u);
    }

    @After
    public void tearDown() {
        repository.deleteAll();
    }

    @Test
    @WithMockUser

    public void testSave() {
        //instancia novo usuário com seus atributos
        User u = new User();
        u.setName("Teste");
        u.setPassword("123124");
        u.setEmail("visfdsdmota98@otmail.com");

        User response = repository.save(u);
        assertNotNull(response);
    }

    @Test
    @WithMockUser
    public void testFindByEmail() {
       Optional<User> response= repository.findByEmailEquals(EMAIL);
        assertTrue(response.isPresent());
        assertEquals(response.get().getEmail(), EMAIL);
    }
}
