package app.web.pavelk.teller1.controller;

import app.web.pavelk.teller1.policy.UserPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

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


}
