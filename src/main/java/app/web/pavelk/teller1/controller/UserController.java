package app.web.pavelk.teller1.controller;

import app.web.pavelk.teller1.model.account.Account;
import app.web.pavelk.teller1.policy.UserPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @GetMapping
    public String name() {
        return userPolicy.getName();
    }

    @GetMapping("/money")
    public String getMoney() {
        return userPolicy.getMoney();
    }

    @GetMapping("/money/add")
    public boolean addMoney(@RequestBody int m) {
        return userPolicy.setMoney(m);
    }


    @GetMapping("/check")
    public int checkBalance(Principal principal) {
        return userPolicy.checkBalance(principal.getName());
    }

    @GetMapping("/payment")
    public boolean paymentBill(Principal principal) {
        return userPolicy.paymentBill(principal.getName());
    }


    @GetMapping("/account")
    public List<Account> getAccount(Principal principal) {
        return userPolicy.getAccount(principal.getName());
    }

    @GetMapping("/account2")
    public Account getAccount2() {
        return userPolicy.getAccount2(1L).get();
    }



}
