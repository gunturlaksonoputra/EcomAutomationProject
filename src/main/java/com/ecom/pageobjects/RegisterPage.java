/**
 * 
 */
package com.ecom.pageobjects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecom.base.BaseClass;

/**
 * 
 */
public class RegisterPage extends BaseClass{
	public RegisterPage() {
		PageFactory.initElements(getDriver(), this);
	}
	Actions act = new Actions(getDriver());

	@FindBy(id = "input-firstname")
	WebElement firstnameField;
	
	@FindBy(id = "input-lastname")
	WebElement lastnameField;
	
	@FindBy(id = "input-email")
	WebElement emailField;
	
	@FindBy(id = "input-telephone")
	WebElement telephoneField;
	
	@FindBy(id = "input-password")
	WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	WebElement confirmpassField;
	
	@FindBy(id = "input-newsletter-yes")
	WebElement newsletteryesButton;
	
	@FindBy(id = "input-newsletter-no")
	WebElement newsletternoButton;
	
	@FindBy(id = "input-agree")
	WebElement agreementChckbox;
	
	@FindBy(css = "input[value='Continue']")
	WebElement continueButton;
	
	@FindBy(css = ".agree")
	WebElement policyButton;
	
	@FindBy(xpath = "//div[@aria-modal='true']//div//div//div//h4[contains(text(),'Privacy Policy')]")
	WebElement policyTitle;
	
	By policyref = By.xpath("//div[@aria-modal='true']//h4[contains(text(),'Privacy Policy')]");
	
	public AccountPage createAccount(String firstname, String lastname, String email, String telephone, String password, String confirmpassword, String newsletter) {
		firstnameField.sendKeys(firstname);
		lastnameField.sendKeys(lastname);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmpassField.sendKeys(confirmpassword);
		if(newsletter.equalsIgnoreCase("yes")){
			newsletteryesButton.click();
		}else {
			newsletternoButton.click();
		}
		continueButton.click();
		
		return new AccountPage();
	}
	public void checkPolicy() {
		policyButton.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(policyref));
		Assert.assertEquals(policyTitle.getText(), "Privacy Policy");
	}
	
	
}
