package com.orangehrm.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
	
	public AdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "menu_admin_Organization")
	private WebElement organizationDropdownMenu;
	
	@FindBy(id = "menu_admin_viewOrganizationGeneralInformation")
	private WebElement generalInformationLink;
	
	@FindBy(id = "btnSaveGenInfo")
	private WebElement editButton;
	
	@FindBy(id = "organization_name")
	private WebElement organizationNameTextbox;
	
	@FindBy(id = "btnSaveGenInfo")
	private WebElement saveButton;
	
	@FindBy(id = "organization_email")
	private WebElement emailTextbox;

	public WebElement getEmailTextbox() {
		return emailTextbox;
	}

	public WebElement getOrganizationDropdownMenu() {
		return organizationDropdownMenu;
	}

	public WebElement getGeneralInformationLink() {
		return generalInformationLink;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getOrganizationNameTextbox() {
		return organizationNameTextbox;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
}
