package app.web.pavelk.teller1.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class BalanceService {

    public int getBalance(String name) {
//        balanceRepository.findByName(name);
        return ThreadLocalRandom.current().nextInt(0, 10);
    }


}
