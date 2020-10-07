package app.web.pavelk.teller1.repository;

import app.web.pavelk.teller1.model.car.Car;
import app.web.pavelk.teller1.model.car.CarDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

//
//    @Query("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = 'true' then 1 else 0 end) " +
//            ") " +
//            "from Car c where c.number = '102' " +
//            "and c.date <= '2020-06-22 19:10:25-07' " +
//            "and c.date > '2011-06-22 19:10:25-07' group by c.code ")


    @Query("select new app.web.pavelk.teller1.model.car.CarDto(" +
            "c.code," +
            " count(c.code)," +
            " sum(case when c.active = true then 1 else 0 end) " +
            ") " +
            "from Car c where c.number = '102' " +
            "group by c.code ")
    List<CarDto> getAllBy(@Param("dataStart") String dataStart,  @Param("data1") String data1 );

//   and c.date <= :data_start
}
