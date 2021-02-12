package com.orangehrm.test;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.generic.BaseTest;

@Listeners(com.orangehrm.generic.ListenerImplementation.class)
public class demo extends BaseTest{
	
	@Test
	public void loginDemo() {
		Reporter.log("Login", true);
	}
}
