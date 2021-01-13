package app.web.pavelk.teller1.service;


import app.web.pavelk.teller1.model.car.Car;
import app.web.pavelk.teller1.model.log.CarLog;
import app.web.pavelk.teller1.repository.CarLogRepository;
import app.web.pavelk.teller1.repository.CarRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class LogService1 {

    private final CarRepository carRepository;
    private final CarLogRepository carLogRepository;
    private final ObjectMapper objectMapper;

//    @Autowired
//    private EntityManager em;

    public void createLog() {
        System.out.println("createLog----------------------------");

        List<Car> all = carRepository.findAll();
        try {
            CarLog cl = CarLog.builder().log("просто лог").car(objectMapper.writeValueAsString(all)).build();
            carLogRepository.save(cl);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getLog() {
        System.out.println("getLog----------------------------");

        String car = carLogRepository.findAll().get(0).getCar();
        System.out.println(car);

        List<Car> asList = null;
        try {
            asList = objectMapper.readValue(car, List.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return asList;
    }
}
