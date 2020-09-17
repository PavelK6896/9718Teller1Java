package app.web.pavelk.teller1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/")//1
    public String main() {
        return "main";
    }


}
