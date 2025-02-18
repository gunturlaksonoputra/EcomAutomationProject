package com.ecom.pageobjects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecom.base.BaseClass;

public class HomePage extends BaseClass{
	
//	@FindBy(className = "carousel-inner")
//	WebElement homeBanner;
//	@FindBy(xpath = "//img[@alt='Poco Electro']")
//	WebElement homeLogo;
	@FindBy(xpath = "//input[@name='search']")
	WebElement searchBar;
	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchButton;
	@FindBy(xpath = "//ul[@class='navbar-nav horizontal']/li[6]")
	WebElement myaccountButton;
	@FindBy(xpath = "//a[contains(@href, 'account/login')]")
	WebElement loginButton;
	@FindBy(xpath = "//a[contains(@href, 'account/register')]")
	WebElement registerButton;
	
	Actions actions = new Actions(getDriver());
		
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
//	public String getHomeTitle() {
//		String homeTitle = getDriver().getTitle();
//		return homeTitle;
//	}
	
//	public boolean validateBanner() {
//		boolean bannerFlag = homeBanner.isDisplayed();
//		return bannerFlag;
//	}
	
	public void goToLoginPage () {
		actions.moveToElement(myaccountButton).build().perform();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'account/login')]")));
		loginButton.click();
	}
	
	public RegisterPage goToRegisterPage () {
		actions.moveToElement(myaccountButton).build().perform();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, 'account/register')]")));
		registerButton.click();
		
		return new RegisterPage();
	}
	
	public SearchPage searchProduct(String productName) {
		searchBar.clear();
		searchBar.sendKeys(productName);
		searchButton.click();
		
		actions.moveToElement(searchBar).click().sendKeys(productName).build().perform();
		return new SearchPage();
	}
 

}
