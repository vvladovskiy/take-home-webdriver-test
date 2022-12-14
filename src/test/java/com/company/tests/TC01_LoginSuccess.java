package com.company.tests;

import com.company.pages.LoginPage;
import com.company.utilities.ConfigurationReader;
import com.company.utilities.Driver;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;

public class TC01_LoginSuccess {

    @Test
    public void loginSuccess() {

        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
        LoginPage loginPage = new LoginPage();

        loginPage.inputUserName.sendKeys(ConfigurationReader.getProperty("username"));
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginBtn.click();

        assertTrue(Driver.getDriver().getCurrentUrl().contains("secure"));

        assertTrue("You logged into a secure area!", loginPage.validCredentials.getText().contains("You logged into a secure area!"));

    }
}
