package app.web.pavelk.teller1.controller;

import app.web.pavelk.teller1.model.account.Account;
import app.web.pavelk.teller1.policy.UserPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserPolicy userPolicy;

    @Autowired
    public UserController(UserPolicy userPolicy) {
        this.userPolicy = userPolicy;
    }


    @GetMapping//2
    public String name() {
        return userPolicy.getName();
    }

    @GetMapping("/money")//3
    public String getMoney() {
        return userPolicy.getMoney();
    }

    @GetMapping("/money/add")//4
    public boolean addMoney(@RequestParam int m) {
        return userPolicy.setMoney(m);
    }

    @GetMapping("/check")//5
    public int checkBalance(Principal principal) {
        return userPolicy.checkBalance(principal.getName());
    }

    @GetMapping("/payment")//6
    public boolean paymentBill(Principal principal) {
        return userPolicy.paymentBill(principal.getName());
    }


    @GetMapping("/account")//7
    public List<Account> getAccount(Principal principal) {
        return userPolicy.getAccount(principal.getName());
    }


}
