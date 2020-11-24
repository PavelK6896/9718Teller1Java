package app.web.pavelk.teller1.repository;

import app.web.pavelk.teller1.model.car.Car;
import app.web.pavelk.teller1.model.car.CarDto2;
import app.web.pavelk.teller1.model.car.CarDto4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car, Long> {


//    @Query("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = 'true' then 1 else 0 end) " +
//            ") " +
//            "from Car c where c.number = '102' " +
//            "and c.date <= '2020-06-22 19:10:25-07' " +
//            "and c.date > '2011-06-22 19:10:25-07' group by c.code ")


//
//    @Query("SELECT s FROM Supplier WHERE s.number= :#{#supplier.number}")
//    Supplier findByNumber(@Param("supplier") Supplier supplier);
//
//    @Query("SELECT s FROM Supplier s WHERE s.number= :#{#supplier.number}")
//    Supplier findByNumber(@Param("supplier") Supplier supplier);


    //-----------------list
//    @Query("select new list(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = true then 1 else 0 end), " +
//            " 9999l " +
//            ") " +
//            "from Car c group by c.code")
//    List<List> getCarDto();
    //----------------------

    //------------------------interfere1
    @Query("select c.number as number, c.code as code, count(c.code) as sumk " +
            "from Car c group by c.code, c.number ")
    List<CarDto2> getCarLong();

    //-----------------------------------interfere2
    @Query("select c.number as number, c.code as code, count(c.code) as sumk " +
            "from Car c group by c.code, c.number ")
    Optional<List<CarDto2>> getCarLongO();


    //--------------------------------------interfere3

    @Query("select c.code as code, c.number as card " +
            "from Car c group by c.number, c.code ")
    List<CarDto4> getCarLongD();


    //------натив get
//    @Query(value = "select " +
//            " sum(case when c.active = true then 1 else 0 end) " +
//            "from cars c group by c.code",
//            nativeQuery = true)
//    List<Long> getCarLong();

    //-----------------map
//    @Query("select new map(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = true then 1 else 0 end), " +
//            " 9999l " +
//            ") " +
//            "from Car c group by c.code")
//    List<List> getCarDto();
    //----------------------


    //-----------------CarDto без масивов
//    @Query("select new app.web.pavelk.teller1.model.car.CarDto(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = true then 1 else 0 end), " +
//            " [1l, 2l, 2l] " +
//            ") " +
//            "from Car c group by c.code")
//    List<CarDto> getCarDto();
    //----------------------


//    @SqlResultSetMappings( {
//            @SqlResultSetMapping(
//                    name = "calendars",
//                    classes = {
//                            @ConstructorResult(
//                                    targetClass = CarDto.class,
//                                    columns = {
//                                            @ColumnResult(name = "code", type = String.class),
//                                            @ColumnResult(name = "email", type = Long.class),
//                                            @ColumnResult(name = "original_id", type = Long.class),
//                                            @ColumnResult(name = "original_id", type = List.class)
//                                    }
//                            )
//                    }
//            ),
//    })


//    @Query("select new map( mother as mother, offspr as offspr, mate as mate ) " +
//            "from DomesticCat as mother" +
//            "    inner join mother.mate as mate" +
//            "    left outer join mother.kittens as offspr" +
//            "select new map( max(c.bodyWeight) as max, min(c.bodyWeight) as min, count(*) as n )\n" +
//            "from Cat cxt ")
//
//    List<CarDto> getCarDto(@Param("dataStart") String dataStart,  @Param("dataEnd") String dataEnd );

//   and c.date <= :data_start

    //приведение строк
//    @Query("select new list(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = true then 1 else 0 end), " +
//            " 9999l " +
//            ") " +
//            "from Car c " +
//            " where concat( :inre , '' ) like '1' " +
//            "group by c.code")
//    List<List> getCarDto(@Param("inre") Integer inre);


//    @Query("select new list(" +
//            "c.code," +
//            " count(c.code)," +
//            " sum(case when c.active = true then 1 else 0 end), " +
//            " 9999l " +
//            ") " +
//            "from Car c " +
//            " where cast(:inre as int)= 1 " +
//            "group by c.code")
//    List<List> getCarDto(@Param("inre") String inre);


}


//all (
//   select spg.points
//   from StatsPerGame spg
//   where spg.player = p
//)


//Example 13.13. Dynamic Instantiation Example - Map
//
//select new map( mother as mother, offspr as offspr, mate as mate )
//from DomesticCat as mother
//    inner join mother.mate as mate
//    left outer join mother.kittens as offspr
//
//select new map( max(c.bodyWeight) as max, min(c.bodyWeight) as min, count(*) as n )
//from Cat cxt
//The results from this query will be a List<Map<String,Object>> as
// opposed to a List<Object[]>. The keys of the map are defined by
// the aliases given to the select expressions.














