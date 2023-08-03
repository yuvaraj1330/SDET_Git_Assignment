package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationAnywhereModified {
	WebDriver driver;
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().win().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.automationanywhere.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
	}

	@Test(priority = 0,timeOut = 60000)
	public void testProductLink() {
		WebElement productLink = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[1]/a"));
		Assert.assertTrue(productLink.isDisplayed(), "Product link is not displayed");
		productLink.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/products",
				"Product link is not navigating to the correct URL");
	}

	@Test(priority = 1, timeOut = 60000)
	public void testSolutionsLink() {
		WebElement solutionsLink = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[2]/a"));
		Assert.assertTrue(solutionsLink.isDisplayed(), "Solutions link is not displayed");
		Actions actions = new Actions(driver);
		actions.moveToElement(solutionsLink).click().perform();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/solutions",
				"Solutions link is not navigating to the correct URL");
	}

	@Test(priority = 2, timeOut = 60000)
	public void testResourcesLink() {
		WebElement resourcesLink = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[3]/a"));
		Assert.assertTrue(resourcesLink.isDisplayed(), "Resources link is not displayed");
		Actions actions = new Actions(driver);
		actions.moveToElement(resourcesLink).click().perform();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/resources",
				"Resources link is not navigating to the correct URL");
	}

	@Test(priority = 3, timeOut = 60000)

	public void testBeyondRPALink() {
		WebElement beyondRPALink = driver
				.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[4]/a"));
		Assert.assertTrue(beyondRPALink.isDisplayed(), "BeyondRPA link is not displayed");
		Actions actions = new Actions(driver);
		actions.moveToElement(beyondRPALink).click().perform();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/rpa/robotic-process-automation",
				"BeyondRPA link is not navigating to the correct URL");
	}

	@Test(priority = 4, timeOut = 60000)
	public void testCompanyLink() {
		WebElement companyLink = driver.findElement(By.xpath(
				"/html/body/div[1]/header/div/div/div/div[2]/div/div/div[2]/ul/li[5]/a"));
		Assert.assertTrue(companyLink.isDisplayed(), "Company link is not displayed");
		Actions actions = new Actions(driver);
		actions.moveToElement(companyLink).click().perform();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.automationanywhere.com/company/about-us",
				"Company link is not navigating to the correct URL");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}