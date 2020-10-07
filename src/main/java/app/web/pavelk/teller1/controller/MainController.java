package app.web.pavelk.teller1.controller;


import app.web.pavelk.teller1.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class MainController {

    private CarService carService;

    @Autowired
    public void setCarService(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")//1
    public String main() {
        carService.getCarDto();
        return "main";
    }


}
