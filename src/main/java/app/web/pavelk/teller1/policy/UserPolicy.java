package app.web.pavelk.teller1.policy;

import app.web.pavelk.teller1.model.account.Account;
import app.web.pavelk.teller1.service.AccountService;
import app.web.pavelk.teller1.service.TellerService;
import app.web.pavelk.teller1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserPolicy {

    private TellerService tellerService;
    private UserService userService;
    private AccountService accountService;


    @Autowired
    public UserPolicy(TellerService tellerService, UserService userService, AccountService accountService) {
        this.tellerService = tellerService;
        this.userService = userService;
        this.accountService = accountService;
    }

    public String getMoney() {
        return tellerService.getMoney();
    }

    public boolean setMoney(int money) {
        return tellerService.setMoney(money);
    }

    public int checkBalance(String name) {
        return tellerService.checkBalance(name);
    }

    public boolean paymentBill(String name) {
        return tellerService.paymentBill(name);
    }

    public String getName() {
        return userService.getName();
    }

    public List<Account> getAccount(String name){
        return userService.getAccount(name);
    }

    public Optional<Account> getAccount2(Long id){
        return accountService.getAccount(id);
    }


}
