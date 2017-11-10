package com.qys.test.sign;

import java.text.SimpleDateFormat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.qys.test.BaseTest;
import com.qys.web.action.SignController;

public class SignTest extends BaseTest{

	@Autowired
	private SignController controller;
	
	@Test
	public void testGet() {
//		String reString = controller.getSignByUnameLimit(null, null, null, null);
//		System.out.println(reString);
	}
	
	@Test
	public void testTime() {
		SimpleDateFormat format = new SimpleDateFormat("HH");
		System.out.println(format.format(System.currentTimeMillis()));
	}
}
