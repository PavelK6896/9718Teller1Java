package app.web.pavelk.teller1.controller;


import app.web.pavelk.teller1.model.car.Car;
import app.web.pavelk.teller1.service.CarService;
import app.web.pavelk.teller1.service.LogService1;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final CarService carService;
    private final LogService1 logService1;


    @GetMapping("/")//1
    public String main() {
        carService.createLog();
        return "main";
    }

    @GetMapping("/1")
    public String main1() {
        logService1.createLog();
        return "main";
    }

    @GetMapping("/2")
    public List<Car> main2() {
        return logService1.getLog();
    }


}
