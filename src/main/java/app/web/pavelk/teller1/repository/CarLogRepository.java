package app.web.pavelk.teller1.repository;


import app.web.pavelk.teller1.model.log.CarLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarLogRepository extends JpaRepository<CarLog, Long> {

}
