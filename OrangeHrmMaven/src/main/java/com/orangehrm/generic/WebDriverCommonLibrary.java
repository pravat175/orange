package com.orangehrm.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Generic class for web actions and waits
 * @author Somes
 *
 */
public class WebDriverCommonLibrary {
	/**
	 * implicit wait
	 * @param driver
	 */
	public static void waitForElementInGUI(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * custom wait
	 * @param element
	 * @throws InterruptedException
	 */
	public static void customWait(WebElement element) throws InterruptedException {
		int i = 0;
		while(i < 50) {
			try {
				if(element.isDisplayed())
					break;
			} catch (Exception e) {
				Thread.sleep(200);
				i++;
			}
		}
	}
	/**
	 * explicit wait for visibility
	 * @param driver
	 * @param element
	 */
	public static void waitForElementVisibility(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * hover action
	 * @param driver
	 * @param element
	 */
	public static void hoverOver(WebDriver driver, WebElement element) {
		Actions action =  new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * context click
	 * @param driver
	 * @param element
	 */
	public static void rightClick(WebDriver driver, WebElement element) {
		Actions action =  new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * select dropdown options by index
	 * @param element
	 * @param index
	 */
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * select dropdown options by text
	 * @param element
	 * @param text
	 */
	public static void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}
}
