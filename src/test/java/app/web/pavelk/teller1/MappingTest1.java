package app.web.pavelk.teller1;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MappingTest1 {

    @Autowired
    private MockMvc mockMvc;

    @Test//1
    @WithMockUser(username = "1", authorities = "developers:write")
    public void mockUserTest1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("main"))
                .andReturn();
    }

    @Test//2
    @WithMockUser(username = "1", authorities = "developers:read")
    public void mockUserTest2() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("name"))
                .andReturn();
    }

    @Test//3
    @WithMockUser(username = "1", authorities = "developers:read")
    public void mockUserTest3() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/money"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isString())
                .andReturn();
    }

    @Test//4
    @WithMockUser(username = "1", authorities = "developers:read")
    public void mockUserTest4() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/money/add?m=1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("true"))
                .andReturn();
    }

    @Test//5
    @WithMockUser(username = "1", authorities = "developers:read")
    public void mockUserTest5() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/check"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNumber())
                .andReturn();
    }

    @Test//6
    @WithMockUser(username = "1", authorities = "developers:read")
    public void mockUserTest6() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/payment"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isBoolean())
                .andReturn();
    }

    @Test//7
    @WithMockUser(username = "1", authorities = "developers:read")
    public void mockUserTest7() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/user/account"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test//8
    @WithMockUser(username = "1", authorities = "developers:write")
    public void mockUserTest8() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("name"))
                .andReturn();
    }

    @Test//9
    @WithMockUser(username = "1", authorities = "developers:write")
    public void mockUserTest9() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admin/video"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("video"))
                .andReturn();
    }

    @Test//10
    @WithMockUser(username = "1", authorities = "developers:write")
    public void mockUserTest10() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admin/log"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("log"))
                .andReturn();
    }

    @Test//11
    @WithMockUser(username = "1", authorities = "developers:write")
    public void mockUserTest11() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admin/statistic"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("Statistic"))
                .andReturn();
    }

    @Test//12
    @WithMockUser(username = "1", authorities = "developers:write")
    public void mockUserTest12() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/admin/role"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value("ADMIN"))
                .andReturn();
    }
}
