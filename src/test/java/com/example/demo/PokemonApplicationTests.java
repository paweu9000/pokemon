package com.example.demo;

import com.example.demo.Service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PokemonApplicationTests {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    UserService userService;

    @Test
    public void mockNotNullTest(){
        Assert.assertNotNull(mockMvc);
    }

    @Test
    @WithAnonymousUser
    public void unauthorizedUserCanEnterHomeTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    public void unauthorizedUserCantEnterTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pokemon"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "gerni", password = "gitarasiema")
    public void authorizedUserCanEnterTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/pokemon"))
                .andExpect(status().isOk());
    }

    @Test
    public void signUpValidTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"login\": \"rekin\", \"username\": \"rekin1\"," +
                        " \"email\": \"rekin@gmail.com\", \"password\": \"piwo123\"}"))
                .andExpect(status().isCreated());
    }

    @Test
    public void signUpInvalidTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"login\": \"rekin\", \"username\": \"rekin1\"," +
                                " \"email\": \"rekin@gmail.com\", \"password\": \"\"}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void authenticateNonExistentUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/authenticate")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"login\": \"rekin\", \"password\": \"piwo123\"}"))
                .andExpect(status().isBadRequest());
    }


}
