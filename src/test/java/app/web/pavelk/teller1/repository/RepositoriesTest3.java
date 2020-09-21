package app.web.pavelk.teller1.repository;

import app.web.pavelk.teller1.model.account.Account;
import app.web.pavelk.teller1.model.user.Role;
import app.web.pavelk.teller1.model.user.Status;
import app.web.pavelk.teller1.model.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

@DataJpaTest//тесты jpa
@ActiveProfiles("test")//отдельные настройки
public class RepositoriesTest3 {
    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private TestEntityManager entityManager;//для настройки базы

    @Test
    public void initAccountTest() {
        List<Account> productsList = accountsRepository.findAll();
        Assertions.assertEquals(4, productsList.size());//количество
    }

    @Test
    public void initUserDbTest() {
        List<User> productsList = userRepository.findAll();
        Assertions.assertEquals(2, productsList.size());//количество
    }

    @Test
    public void accountsRepositoryTest() {
        //настраиваем базу при старте
        Account account = new Account();
        account.setUser(userRepository.findById(1L).get());
        account.setBill(300L);
        Account account2 = entityManager.persist(account);//настаивать
        entityManager.flush();
        //--

        List<Account> productsList = accountsRepository.findAll();
        Assertions.assertEquals(5, productsList.size());//проверка отдельной базы
        Assertions.assertEquals(300L, productsList.get(4).getBill());//проверка добавленного
    }


    @Test
    public void userRepositoryTest() {
        //настраиваем базу при старте
        User user = new User();
        user.setEmail("u@u");
        user.setFirstName("u1");
        user.setLastName("u2");
        user.setPassword("uuu");
        user.setRole(Role.ADMIN);
        user.setStatus(Status.ACTIVE);
        User user1 = entityManager.persist(user);//настаивать
        entityManager.flush();
        //--

        List<User> productsList = userRepository.findAll();
        System.out.println(productsList.get(2).getAccount());
        Assertions.assertEquals(3, productsList.size());
        Assertions.assertEquals("u@u", productsList.get(2).getEmail());
        Assertions.assertEquals(Role.ADMIN, productsList.get(2).getRole());
    }


}
