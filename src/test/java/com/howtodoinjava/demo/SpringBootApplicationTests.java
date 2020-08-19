package com.howtodoinjava.demo;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.Assert;

@SpringBootTest
public class SpringBootApplicationTests {

	@Test
	public void validCPF() 
	{	
		Assert.assertTrue("397.643.358-61".contentEquals(com.brasil.prev.util.Util.FormatCPF("39764335861")));
	}

}
