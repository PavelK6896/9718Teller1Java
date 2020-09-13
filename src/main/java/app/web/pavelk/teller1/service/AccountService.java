package app.web.pavelk.teller1.service;

import app.web.pavelk.teller1.model.account.Account;
import app.web.pavelk.teller1.model.user.User;
import app.web.pavelk.teller1.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private AccountsRepository accountsRepository;

    @Autowired
    public void setAccountsRepository(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public void init(User user){

        Account account = new Account();
        System.out.println(account.getId());
        account.setBill(999L);
        account.setUser(user);

        accountsRepository.save(account);
    }

    public Optional<Account> getAccount(Long id){
       return accountsRepository.findById(id);
    }

}
