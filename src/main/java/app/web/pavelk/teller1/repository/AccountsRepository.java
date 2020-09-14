package app.web.pavelk.teller1.repository;

import app.web.pavelk.teller1.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Account, Long> {
}
