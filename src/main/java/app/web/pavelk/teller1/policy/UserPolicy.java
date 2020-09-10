package app.web.pavelk.teller1.policy;

import app.web.pavelk.teller1.service.TellerService;
import app.web.pavelk.teller1.service.UserService;
import app.web.pavelk.teller1.state.Context;
import app.web.pavelk.teller1.state.State;
import app.web.pavelk.teller1.state.State1;
import app.web.pavelk.teller1.state.State2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;

@Component
public class UserPolicy implements Context {

    private TellerService tellerService;
    private UserService userService;


    @Autowired
    public UserPolicy(TellerService tellerService, UserService userService) {
        this.tellerService = tellerService;
        this.userService = userService;
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
}
