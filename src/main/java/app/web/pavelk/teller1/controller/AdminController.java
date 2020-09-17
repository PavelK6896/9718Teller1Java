package app.web.pavelk.teller1.controller;

import app.web.pavelk.teller1.model.user.Role;
import app.web.pavelk.teller1.policy.AdminPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminPolicy adminPolicy;

    @Autowired
    public void setAdminPolicy(AdminPolicy adminPolicy) {
        this.adminPolicy = adminPolicy;
    }

    @GetMapping//8
    public String name() {
        return adminPolicy.getName();
    }


    @GetMapping("/video")//9
    public String video() {
        return adminPolicy.getVideo();
    }


    @GetMapping("/log")//10
    public String log() {
        return adminPolicy.getLog();
    }

    @GetMapping("/statistic")//1
    public String statistic() {
        return adminPolicy.getStatistic();
    }


    //@Secured("ADMIN")
    //@PreAuthorize("hasAuthority('developers:write')")
    @GetMapping("/role")//12
    public String admin(Principal principal) {
        Role role = adminPolicy.getRole(principal.getName());
        return role.toString();
    }

}
