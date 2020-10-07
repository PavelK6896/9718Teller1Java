package app.web.pavelk.teller1.service;

import app.web.pavelk.teller1.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    private EntityManager em;
//    em.createQuery("from Car c").getResultList()
//    em.createQuery("select new app.web.pavelk.teller1.model.car.CarDto(c.code, 0l, 0l) from Car c").getResultList();

//    em.createQuery("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " 0l) " +
//            "from Car c group by c.code").getResultList();


//    em.createQuery("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " 0l) " +
//            "from Car c where c.number = '102' group by c.code").getResultList();


//    em.createQuery("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " count(case when c.active = 'true' then 1 else 0 end)  " +
//            ") " +
//            "from Car c where c.number = '102' group by c.code").getResultList();

//    em.createQuery("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = 'true' then 1 else 0 end) " +
//            ") " +
//            "from Car c where c.number = '102' group by c.code ").getResultList();

//    em.createQuery("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = 'true' then 1 else 0 end) " +
//            ") " +
//            "from Car c where c.number = '102' " +
//            "and c.date <= '2020-06-22 19:10:25-07' " +
//            "and c.date > '2011-06-22 19:10:25-07' group by c.code ").getResultList();

    public void getCarDto() {

        System.out.println(carRepository.findAll());
        System.out.println("*****************");

        final DateTimeFormatter DATE_TIME_F_DOTED = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String dateEnd = LocalDateTime.now().format(DATE_TIME_F_DOTED);
        System.out.println();

        System.out.println(carRepository.getAllBy("2010-06-22 19:10:25-07", dateEnd));
    }
}
