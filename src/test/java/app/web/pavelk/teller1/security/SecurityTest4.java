package app.web.pavelk.teller1.security;


import app.web.pavelk.teller1.model.user.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityTest4 {
    @Autowired
    private MockMvc mockMvc;//тестовое окружение

    @Test
    public void correctLoginUser1() throws Exception {//user1
        mockMvc.perform(formLogin("/login").user("1").password("1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())//перенаправление
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void correctLoginUser2() throws Exception {//user2
        mockMvc.perform(formLogin("/login").user("2").password("1"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"));
    }

    @Test//неправильный логин пароль
    public void badCredentials() throws Exception {
        mockMvc.perform(formLogin("/login").user("admin").password("100"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error"));
    }

    @Test//без авторизации на форму логина
    public void securityAccessDeniedTest() throws Exception {
        mockMvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    public void correctLoginUserAdmin() throws Exception {
        mockMvc.perform(formLogin("/login").user("1").password("1"))
                .andDo(print())
                .andExpect(authenticated().withUsername("1"))
                .andExpect(authenticated().withAuthorities(Role.ADMIN.getAuthorities()));//прова админа
    }

    @Test
    public void accessSecuredResourceUnauthenticatedThenRedirectsToLogin() throws Exception {
        mockMvc.perform(get("/user"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrlPattern("**/login"));
    }

}
