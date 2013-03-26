package com.osintegrators.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.AnnotatedElement;

/**
 * Description:
 *
 * @author dmistry@osintegrators.com
 *         Date: 2/20/13
 *         Time: 1:55 PM
 */
@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRest {

	private static RestTemplate restTemplate;

	@BeforeClass
	public static void setUp(){

		restTemplate = new RestTemplate();
	}

	@Test
	public void testCreate(){
		String url = "http://localhost:8080/SpringMongoGranny/create";
		Address address = new Address();
		address.setName("Deepaalalalalal");
		address.setAddress("as");
		restTemplate.postForLocation(url,address);
	}
}
