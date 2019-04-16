package com.backend.restclient;

import com.backend.restclient.services.JokeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestclientApplicationTests {


	private Logger logger = LoggerFactory.getLogger(JokeService.class);

	@Test
	public void contextLoads() {
	}

	@Autowired
	private JokeService service;

	@Test
	public void getJoke() throws Exception {
		String joke = service.getJoke("Craig", "Walls");
		logger.info(joke);
		assertTrue(joke.contains("Craig") ||
				joke.contains("Walls"));
	}

}
