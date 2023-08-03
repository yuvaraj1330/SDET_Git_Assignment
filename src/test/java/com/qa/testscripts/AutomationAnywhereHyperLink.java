package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereHyperLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		WebDriverManager.chromedriver().win().setup();
		driver = new ChromeDriver();
		driver.get("https://www.automationanywhere.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		SoftAssert SoftAssert = new SoftAssert();
		Actions actions = new Actions(driver);

		WebElement Product = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[1]/a"));
		WebElement Solutions = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[2]/a"));
		WebElement Resources = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[3]/a"));
		WebElement BeyondRPA = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[4]/a"));
		WebElement Company = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[5]/a"));

		SoftAssert.assertTrue(Product.isDisplayed());
		SoftAssert.assertTrue(Solutions.isDisplayed());
		SoftAssert.assertTrue(Resources.isDisplayed());
		SoftAssert.assertTrue(BeyondRPA.isDisplayed());
		SoftAssert.assertTrue(Company.isDisplayed());


		Product.click();
		System.out.println("Navigated to Product page");

		Thread.sleep(2000);
		actions.moveToElement(Solutions).click();
		SoftAssert.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/Solutions"));
		System.out.println("Navigated to Solutions page");

		Thread.sleep(2000);
		actions.moveToElement(Resources).click();
		SoftAssert.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/Resources"));
		System.out.println("Navigated to Resources page");

		Thread.sleep(2000);
		actions.moveToElement(BeyondRPA).click();
		SoftAssert.assertTrue(
				driver.getCurrentUrl().equals("https://www.automationanywhere.com/rpa/robotic-process-automation"));
		System.out.println("Navigated to BeyondRPA page");

		Thread.sleep(2000);
		actions.moveToElement(Company).click();

		SoftAssert.assertTrue(driver.getCurrentUrl().equals("https://www.automationanywhere.com/Company/about-us"));
		System.out.println("Navigated to Company page");

		System.out.println("Links are navigating to required page");

		driver.close();

	}
}
