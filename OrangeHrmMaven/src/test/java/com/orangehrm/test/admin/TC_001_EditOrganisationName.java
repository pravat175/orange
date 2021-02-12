package com.orangehrm.test.admin;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.generic.BaseTest;
import com.orangehrm.generic.FileLibrary;
import com.orangehrm.generic.WebDriverCommonLibrary;
import com.orangehrm.pom.AdminPage;
import com.orangehrm.pom.Homepage;
/**
 * TC_001 edit organization integration test case
 * @author Somes
 *
 */
@Listeners(com.orangehrm.generic.ListenerImplementation.class)
public class TC_001_EditOrganisationName extends BaseTest{
	@Test
	public void editOrganisationName() throws EncryptedDocumentException, IOException, InvalidFormatException {
		Homepage homepage = new Homepage(driver);
		// step#6 click admin module
		homepage.getAdminDropdownMenu().click();
		AdminPage adminPage = new AdminPage(driver);
		// step#7 hover to organization dropdown
		WebDriverCommonLibrary.hoverOver(driver, adminPage.getOrganizationDropdownMenu());
		// step#8 click general information link
		WebDriverCommonLibrary.waitForElementVisibility(driver, adminPage.getGeneralInformationLink());
		adminPage.getGeneralInformationLink().click();
		// step#9 click edit button
		WebDriverCommonLibrary.waitForElementVisibility(driver, adminPage.getEditButton());
		adminPage.getEditButton().click();
		// step#10 delete organization name
		String organizationName = FileLibrary.getExcelValue("organizationTestData", 0, 0);
		WebDriverCommonLibrary.waitForElementVisibility(driver, adminPage.getOrganizationNameTextbox());
		adminPage.getOrganizationNameTextbox().clear();
		// step#11 enter new organization name
		adminPage.getOrganizationNameTextbox().sendKeys(organizationName);
		// step#12 delete email
		String email = FileLibrary.getExcelValue("organizationTestData", 0, 1);
		WebDriverCommonLibrary.waitForElementVisibility(driver, adminPage.getEmailTextbox());
		adminPage.getEmailTextbox().clear();
		// step#13 enter email
		adminPage.getEmailTextbox().sendKeys(email);
		// step#14 click save
		WebDriverCommonLibrary.waitForElementVisibility(driver, adminPage.getSaveButton());
		adminPage.getSaveButton().click();
		// step#15 validation
		String expectedOrganization = organizationName;
		String actualOrganization = adminPage.getOrganizationNameTextbox().getAttribute("value");
		
		String expectedEmail = email;
		String actualEmail = adminPage.getEmailTextbox().getAttribute("value");
		
		assertEquals(expectedOrganization.equals(actualOrganization), true);

		assertEquals(expectedEmail.equals(actualEmail), true);
	}
}
