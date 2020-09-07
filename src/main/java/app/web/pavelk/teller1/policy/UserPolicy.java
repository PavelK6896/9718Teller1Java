package app.web.pavelk.teller1.policy;

import app.web.pavelk.teller1.service.TellerService;
import app.web.pavelk.teller1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPolicy {

    private TellerService tellerService;
    private UserService userService;


    @Autowired
    public UserPolicy(TellerService tellerService, UserService userService) {
        this.tellerService = tellerService;
        this.userService = userService;
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

}
