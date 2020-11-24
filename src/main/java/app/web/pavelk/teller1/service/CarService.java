package app.web.pavelk.teller1.service;

import app.web.pavelk.teller1.model.car.Car;
import app.web.pavelk.teller1.model.car.CarDto2;
import app.web.pavelk.teller1.model.car.CarDto4;
import app.web.pavelk.teller1.repository.CarRepository;
import app.web.pavelk.teller1.repository.ReportsCustom;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CarService {

    private final CarRepository carRepository;

//    @PersistenceContext
//    private EntityManager em;

    @Autowired
    private EntityManager em;

    @Autowired
    private ReportsCustom reportsCustom;
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
//-------------------------------------------------


//    insert into cars (number, code, active, date)
//    values ('102', '10', false, '2016-06-22 19:10:25-07'),


    //-----------------
//    @Query(value = "insert into cars (id, number) values (51 , '102')",
//            nativeQuery = true)
//    List getCarDtoSet();

    public void getCarDto() {

//        System.out.println(carRepository.findAll());
//        System.out.println("*****************");
//        final DateTimeFormatter DATE_TIME_F_DOTED = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
//        String dateEnd = LocalDateTime.now().format(DATE_TIME_F_DOTED);


        //1--------------------------sum
//        String q =  "select sum( case when c.active = true then 1 else 0 end ) from Car c group by c.active";
//        List resultList = em.createQuery(q).getResultList();

        //2-----------native get
//        String q =  "select number from cars ";
//        List resultList = em.createNativeQuery(q).getResultList();
//        System.out.println(resultList);

        //3-----------native get
//        String q =  "select * from cars ";
//        List resultList = em.createNativeQuery(q, Car.class).getResultList();

        //4-----------native get
//        String q =  "select count(cars.id) from cars ";
//        List resultList = em.createNativeQuery(q).getResultList();


        //5-----------native get
//        String q =  "select sum( case when cars.active = true then 1 else 0 end ) from cars ";
//        List resultList = em.createNativeQuery(q).getResultList();

        //6-----------native get
//        String q =  "select sum( case when ca.active = true then 1 else 0 end ) from cars as ca";
//        List resultList = em.createNativeQuery(q).getResultList();

        //7-----------native get
//        String q =  "select  ca.active, ca.number from cars as ca";
//        List resultList = em.createNativeQuery(q, "post-entity-graph").getResultList();
//
//
//
//        System.out.println(resultList.size());
//        resultList.forEach(l -> {
//
//
//
//            System.out.println( l.getClass());
//        });


        //8-----------native get не работает
//        Query q = em.createNativeQuery(
//                "SELECT o.id AS order_id, " +
//                        "o.quantity AS order_quantity, " +
//                        "o.item AS order_item, " +
//                        "i.name AS item_name " +
//                        "FROM Order o, Item i " +
//                        "WHERE (order_quantity > 25) AND (order_item = i.id)",
//                "OrderResults");
//
//        @SqlResultSetMapping(name="OrderResults",
//                entities={
//                        @EntityResult(entityClass = com.acme.Order.class, fields={
//                                @FieldResult(name="id", column="order_id"),
//                                @FieldResult(name="quantity", column="order_quantity"),
//                                @FieldResult(name="item", column="order_item")})},
//                columns={
//                        @ColumnResult(name="item_name")}
//        )


//        Query q = em.createNativeQuery(
//                "SELECT 1l, ca.active , ca.number  " +
//                        "FROM  cars as ca ",
//                "SomeMapping");


        //9---------
//        Query query = em.createNativeQuery("SELECT ca.active , ca.number FROM cars as ca", Car2Dto.class);
//        @SuppressWarnings("unchecked")
//        List<Car2Dto> items = (List<Car2Dto>) query.getResultList();

        //10---
//        TypedQuery<Car2Dto> query = em.createNamedQuery("carsQry", Car2Dto.class);
//        List<Car2Dto> items = query.getResultList();

        //11
//        List<EmployeeResult> employeeIds = em.createNamedQuery("Employees", EmployeeResult.class).getResultList();
//        System.out.println(employeeIds);


        //annotation *****
        //12--------------------*************************
//        List<Object[]> employees = em.createNamedQuery("Employees").getResultList();
//        System.out.println(employees.get(1)[0]);
//        System.out.println(employees.get(1)[1]);

        //13------------------------
//        List<EmployeeResult> employees = em.createNamedQuery("Employees", EmployeeResult.class).getResultList();
//        System.out.println(employees.get(1).getActive());
//        System.out.println(employees.get(1).getNumber());


        //text
        //14-------------------------
//        List<Object[]> employees = em.createNativeQuery("SELECT number, active FROM cars").getResultList();
//        System.out.println(employees.get(1)[0]);
//        System.out.println(employees.get(1)[1]);

        //15-------------------cast mapping
//        List<Object> employees = em.createNativeQuery("SELECT number, active FROM cars" , "EmployeeResult" ).getResultList();
//        EmployeeResult employeeResult = (EmployeeResult) employees.get(1);
//        System.out.println(employeeResult);


        //16------------------------
//        reportsCustom.testQueryNativeRequestInsert();
//        reportsCustom.testQueryNativeRequestInsert();
//        reportsCustom.testQueryNativeRequestInsert();
//        reportsCustom.testQueryNativeRequest();

        //17--------
//        reportsCustom.testQueryNativeRequest2();

        System.out.println("-----------------------------------");
        System.out.println();
//        System.out.println(carRepository.getCarLong());

        //------------interfere1
//        carRepository.getCarLong().forEach(p -> {
//            System.out.println(p.getNumber());
//            System.out.println(p.getCode());
//            System.out.println("-- " + p.getSumk());
//        });
//
//        //-------------------------------------interfere2Optional1error
//        Optional<List<CarDto2>> carLongO = carRepository.getCarLongO();
//        if (carLongO.isPresent()) {
//            List<CarDto2> carDto2s = carLongO.get();
//            System.out.println(carDto2s.size());
//            System.out.println("----------------");
//        }
//
//        Optional<Integer> integer = carLongO.map(List::size);
//        integer.ifPresent(System.out::println);
//
//        //-------------------------------------interfere2Optional2error
//        try {
//            List<CarDto2> carDto2s = carRepository.getCarLongO().map(l -> l.stream().collect(Collectors.toList()))
//                    .orElseThrow(() -> new Exception("not found - "));
//            System.out.println(carDto2s.size());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //-------------------------------------interfere3
       carRepository.getCarLongD().forEach(p -> {
           System.out.println("class " +  p.getCard().getClass().toString() + "p2= " + p.getCard().getName());
           System.out.println("p1= " + p.getCode());
       });



//        List<CarDto2> carDto2s = carRepository.getCarLong().orElseThrow();
//     carDto2s.forEach(l -> {
//     // Optional.ofNullable(l.getCode()).ifPresent(System.out::println);
////         System.out.println(l.getNumber());
////         System.out.println(l.getSumk());
////         Long sumk = l.getSumk();
////         System.out.println(sumk);
//     });

        System.out.println("-----------------------------------");
    }
}
