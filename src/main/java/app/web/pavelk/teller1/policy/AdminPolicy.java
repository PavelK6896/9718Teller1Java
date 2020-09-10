package app.web.pavelk.teller1.policy;

import app.web.pavelk.teller1.model.user.Role;
import app.web.pavelk.teller1.service.LogService;
import app.web.pavelk.teller1.service.StatisticService;
import app.web.pavelk.teller1.service.UserService;
import app.web.pavelk.teller1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminPolicy {

    private UserService userService;
    private LogService logService;
    private VideoService videoService;
    private StatisticService statisticService;

    @Autowired
    public AdminPolicy(UserService userService, LogService logService,
                       VideoService videoService, StatisticService statisticService) {
        this.userService = userService;
        this.logService = logService;
        this.videoService = videoService;
        this.statisticService = statisticService;
    }

    public String getVideo() {
        return videoService.getVideo();
    }

    public String getLog() {
        return logService.getLog();
    }

    public String getStatistic() {
        return statisticService.getStatistic();
    }

    public String getName() {
        return userService.getName();
    }

    public Role getRole(String name) {
        return userService.getRole(name);
    }


}
