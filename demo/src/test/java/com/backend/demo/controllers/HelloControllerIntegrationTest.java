package com.backend.demo.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerIntegrationTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    public HelloControllerIntegrationTest() {
    }

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testHelloWithoutName() throws Exception {
        mockMvc.perform(
                get("/hello").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", is("World")));

    }

    @Test
    public void testHelloWithName() throws Exception {
        mockMvc.perform(
                get("/hello").param("ame", "Jorge").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", is("Jorge")));

    }
}