package test.prog.Test.service;
import org.springframework.http.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import test.prog.controller.ProfileController;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRunner.class)
@WebMvcTest(ProfileController.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 public class profileServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSayHelloWorld() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/profile/get/1").accept(org.springframework.http.MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

}