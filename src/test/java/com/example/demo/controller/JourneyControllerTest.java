package com.example.demo.controller;

import com.example.demo.DemoDeliveryApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = DemoDeliveryApplication.class)
@AutoConfigureMockMvc
@Sql("/test.sql")
class JourneyControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    @Transactional //не хватало часу тому написав тільки 1 тест
    void search() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/api/journey/search")
                .accept(MediaType.APPLICATION_JSON)
                .param("fromStationId", "1")
                .param("toStationId", "3")
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"transportId\":1,\"crewId\":1,\"tripList\":null}]"));
    }
}
