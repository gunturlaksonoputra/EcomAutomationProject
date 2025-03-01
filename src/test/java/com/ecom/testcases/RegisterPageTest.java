/**
 * 
 */
package com.ecom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecom.base.BaseClass;
import com.ecom.dataprovider.DataProviders;
import com.ecom.pageobjects.HomePage;
import com.ecom.pageobjects.RegisterPage;

/**
 * 
 */
public class RegisterPageTest extends BaseClass {
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Regression")
	public void moveToRegisterPage() {
//		getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?");
		HomePage homepage = new HomePage();
		homepage.goToRegisterPage();
	}
	
	@Test(groups = "Regression")
	public void checkPrivacyPolicy() {
//		getDriver().get("https://ecommerce-playground.lambdatest.io/index.php?");
		HomePage homepage = new HomePage();
		RegisterPage registerpage = homepage.goToRegisterPage();
		registerpage.checkPolicy();
	}
	
//	@Test(groups = "Regression", dataProvider = "registerdata", dataProviderClass = DataProviders.class)
//	public void registerAccount(String firstname, String lastname, String email, String telephone, String password, String confirmpassword, String newsletter ) {
//		HomePage homepage = new HomePage();
//		RegisterPage registerpage = homepage.goToRegisterPage();
//		registerpage.createAccount(firstname, lastname, email, telephone, password, confirmpassword, newsletter);
//	}
}
