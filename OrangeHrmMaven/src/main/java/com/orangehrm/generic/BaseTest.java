package com.orangehrm.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.orangehrm.pom.Homepage;
import com.orangehrm.pom.LoginPage;
/**
 * base test containing before class and before moethods
 * @author Somes
 *
 */
@Listeners(com.orangehrm.generic.ListenerImplementation.class)
public class BaseTest {

	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./src/main/resources/driver/geckodriver.exe");
	}
	
	public static WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void openBrowser(@Optional("chrome") String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		WebDriverCommonLibrary.waitForElementInGUI(driver);
	}
	@BeforeMethod
	public void login() throws IOException {
		String url = FileLibrary.getPropetyValue("url");
		String username = FileLibrary.getPropetyValue("username");
		String password = FileLibrary.getPropetyValue("password");
		driver.get(url);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getUsernameTextbox().sendKeys(username);
		loginPage.getPasswordTextbox().sendKeys(password);
		loginPage.getLoginButton().click();
	}
	
	@AfterMethod
	public void logout() {
		Homepage homepage = new Homepage(driver);
		homepage.getUserIcon().click();
		homepage.getLogoutLink().click();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
}
