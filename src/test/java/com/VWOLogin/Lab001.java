package com.VWOLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lab001 {

	@Test
	public void TC001_Positive() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);

		//Logging into VWO and getting the title
		driver.get("https://app.vwo.com/#/login");
		Thread.sleep(3000);

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "Login - VWO");

		//Entering username
		WebElement login = driver.findElement(By.id("login-username"));
		login.sendKeys("admin1999@gmail.com");

		//Entering Password
		WebElement password = driver.findElement(By.id("login-password"));
		password.sendKeys("Admin@99");

		Thread.sleep(1000);

		//Clicking on the sign-in button
		WebElement sign_in_Button = driver.findElement(By.id("js-login-btn"));
		sign_in_Button.click();

		Thread.sleep(6000);

		//verifying the title again on the dashboard page
		Assert.assertEquals(driver.getTitle(), "VWO Setup");

		WebElement verify = driver.findElement(By.xpath("//div[text()=' admin1999@gmail.com ']"));
		System.out.println(verify.isDisplayed());

		driver.quit();
	}
}
