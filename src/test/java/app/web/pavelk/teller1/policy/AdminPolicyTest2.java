package app.web.pavelk.teller1.policy;


import app.web.pavelk.teller1.model.user.Role;
import app.web.pavelk.teller1.policy.AdminPolicy;
import app.web.pavelk.teller1.service.LogService;
import app.web.pavelk.teller1.service.StatisticService;
import app.web.pavelk.teller1.service.UserService;
import app.web.pavelk.teller1.service.VideoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class AdminPolicyTest2 {

    @Autowired
    private AdminPolicy adminPolicy;

    @MockBean
    private VideoService videoService;

    @MockBean
    private LogService logService;

    @MockBean
    private StatisticService statisticService;

    @MockBean
    private UserService userService;


    @Test
    public void getVideo() {
        Mockito.doReturn("video Test")
                .when(videoService)
                .getVideo();
        String video = adminPolicy.getVideo();
        Assertions.assertNotNull(video);
        Mockito.verify(videoService, Mockito.times(1))//метод вызван только один раз
                .getVideo();
    }

    @Test
    public void getLog() {
        Mockito.doReturn("log Test")
                .when(logService)
                .getLog();

        String log = adminPolicy.getLog();
        Assertions.assertNotNull(log);
        Mockito.verify(logService, Mockito.times(1))
                .getLog();
    }

    @Test
    public void getStatistic() {
        Mockito.doReturn("statistic Test")
                .when(statisticService)
                .getStatistic();

        String statistic = adminPolicy.getStatistic();
        Assertions.assertNotNull(statistic);
        Mockito.verify(statisticService, Mockito.times(1))
                .getStatistic();
    }

    @Test
    public void getName() {
        Mockito.doReturn("name Test")
                .when(userService)
                .getName();

        String name = adminPolicy.getName();
        Assertions.assertNotNull(name);
        Mockito.verify(userService, Mockito.times(1))
                .getName();
    }

    @Test
    public void getRole() {
        Mockito.doReturn(Role.ADMIN)
                .when(userService)
                .getRole("name");

        Role role = adminPolicy.getRole("name");
        Assertions.assertNotNull(role);
        Mockito.verify(userService, Mockito.times(1))
                .getRole("name");
    }
}
