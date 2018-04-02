package com.sk.sheikhpura.test.tests;

import static org.junit.Assert.assertEquals;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.sk.sheikhpura.config.AppMain;
import com.sk.sheikhpura.config.SecurityInitializer;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class, classes = {AppMain.class, SecurityInitializer.class})
@WebAppConfiguration
public class MyTest {

	@Test
	public void testUser() {
		assertEquals("Hi", 1 ,1);
	}
	
	
}
