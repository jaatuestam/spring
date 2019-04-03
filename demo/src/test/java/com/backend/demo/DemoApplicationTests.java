package com.backend.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.NumberFormat;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private ApplicationContext ctx;

	@Autowired @Qualifier("frenchCurrencyFormatter")
	private NumberFormat nf;

	@Test
	public void contextLoads() {
		System.out.printf("There are %d beans in the applicationContext%n", ctx.getBeanDefinitionCount());
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
	}

	@Test
	public void testLocalCurrencyFormat() {
		double amount = 123456.7890123;
		NumberFormat local = ctx.getBean("localCurrencyFormatter", NumberFormat.class);
		String formatted = local.format(amount);
		System.out.println(formatted);
	}


	@Test
	public void testFrenchCurrencyFormat() {
		double amount = 123456.7890123;
		String formatted = nf.format(amount);
		System.out.println(formatted);
		assertEquals("123 456,79 €",formatted);
	}
}
