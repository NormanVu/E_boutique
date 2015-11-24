package org.youssfi.boutique;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {

	@Test
	public void test() {
		try {
			ClassPathXmlApplicationContext app=
			new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			assertTrue(true);
			} catch (Exception e) {
			assertTrue(e.getMessage(),false);
			} }
	}


