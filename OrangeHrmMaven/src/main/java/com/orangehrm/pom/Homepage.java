package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage{
	/////////////////////////////////////////////////WEBELEMENTS//////////////////////
	@FindBy(id = "welcome")
	private WebElement userIcon;
	
	@FindBy(xpath = "//a[@href='/index.php/auth/logout']")
	private WebElement logoutLink;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElement adminDropdownMenu;
	
	////////////////////////////////////////////////CONSTRUCTOR///////////////////////
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    ////////////////////////////////////////////////WEBELEMENT GETTERS//////////////
	
	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}
	
	public WebElement getAdminDropdownMenu() {
		return adminDropdownMenu;
	}
	
}