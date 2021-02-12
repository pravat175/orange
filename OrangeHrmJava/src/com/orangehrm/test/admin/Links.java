package com.orangehrm.test.admin;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public final class Links {
	static{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String url = sc.next();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		List<WebElement> linkList =  driver.findElements(By.tagName("a"));
		System.out.println(linkList.size());
		for(WebElement link : linkList) {
			if(!link.getText().isEmpty())
				System.out.println(link.getText());
		}
		driver.close();
	}

}
