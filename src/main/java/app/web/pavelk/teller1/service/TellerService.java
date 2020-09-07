package app.web.pavelk.teller1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TellerService {

    private BalanceService balanceService;

    @Autowired
    public void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    public String getMoney() {
        return "money";
    }

    public boolean setMoney(int money) {
        return true;
    }

    public int checkBalance(String name) {
        return balanceService.getBalance(name);
    }

    public boolean paymentBill(String name) {
        if (balanceService.getBalance(name) < 5) {
            return false;
        }
        return true;
    }

}
