/**
 * 
 */
package com.ecom.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecom.base.BaseClass;
import com.ecom.dataprovider.DataProviders;
import com.ecom.pageobjects.HomePage;

/**
 * 
 */
@Listeners({com.ecom.utility.ListenerClass.class})
public class EndToEndTest extends BaseClass{
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(@Optional("Chrome") String browser) {
		launchApp(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
		
	// @Test(groups = "Sanity",dataProvider = "endtoendData", dataProviderClass = DataProviders.class)
	// public void endToEndTest(String username, String password, String searchprod, String product, String qty ) {
		
	// }
	
}
