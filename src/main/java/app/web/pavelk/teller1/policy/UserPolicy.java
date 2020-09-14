package app.web.pavelk.teller1.policy;

import app.web.pavelk.teller1.model.account.Account;
import app.web.pavelk.teller1.service.AccountService;
import app.web.pavelk.teller1.service.TellerService;
import app.web.pavelk.teller1.service.UserService;
import app.web.pavelk.teller1.state.Context;
import app.web.pavelk.teller1.state.State;
import app.web.pavelk.teller1.state.State1;
import app.web.pavelk.teller1.state.State2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

import java.util.List;
import java.util.Optional;


@Component
public class UserPolicy implements Context {

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

        return tellerService.getMoney() + " "+ request().handle();
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


    @Override
    public State request() {
        if (ThreadLocalRandom.current().nextInt(0, 5) > 2) {
            return new State1();
        }
        return new State2();
    }

    public List<Account> getAccount(String name){
        return userService.getAccount(name);
    }

    public Optional<Account> getAccount2(Long id){
        return accountService.getAccount(id);
    }

}
