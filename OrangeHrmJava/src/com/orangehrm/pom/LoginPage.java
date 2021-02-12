package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	@FindBy(id="txtUsername")
	private WebElement usernameTextbox;
	
	@FindBy(id="txtPassword")
	private WebElement passwordTextbox;
	
	@FindBy(id="btnLogin")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameTextbox() {
		return usernameTextbox;
	}

	public WebElement getPasswordTextbox() {
		return passwordTextbox;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
}
