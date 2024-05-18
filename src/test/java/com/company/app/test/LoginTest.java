package com.company.app.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    String homeTitle = "//android.widget.TextView[@text=\"WEBDRIVER\"]";
    String loginMenu = "//android.widget.TextView[@text=\"Login\"]";
    String loginTitle = "(//android.widget.TextView[@text=\"Login\"])[1]";
    String fieldEmail = "//android.widget.EditText[@content-desc=\"input-email\"]";
    String fieldPassword = "//android.widget.EditText[@content-desc=\"input-password\"]";
    String loginButton = "//android.view.ViewGroup[@content-desc=\"button-LOGIN\"]";
    String successTitle = "android:id/alertTitle";
    String loggedInText = "android:id/message";
    String okButton = "android:id/button1";
    String invalidEmail = "//android.widget.TextView[@text=\"Please enter a valid email address\"]";
    String invalidPassword = "//android.widget.TextView[@text=\"Please enter at least 8 characters\"]";

    @Test
    public void testSuccessfulLogin() {
        // After open android app then verify the home page
        driver.findElementByXPath(homeTitle).isDisplayed();

        // Navigate to Login page
        driver.findElementByXPath(loginMenu).isDisplayed();
        driver.findElementByXPath(loginMenu).click();

        // Input valid email and password, then login
        driver.findElementByXPath(loginTitle).isDisplayed();
        driver.findElementByXPath(fieldEmail).sendKeys("heyjoni@mail.com");
        driver.findElementByXPath(fieldPassword).sendKeys("hello123");
        driver.findElementByXPath(loginButton).click();

        // Verify successfully logged in
        WebDriverWait wait = new WebDriverWait(driver, 30); // Wait for 30 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(successTitle)));

        // Verify success message
        String successMessage = driver.findElementById(successTitle).getText();
        Assert.assertEquals(successMessage, "Success");

        String successLoggedInMessage = driver.findElementById(loggedInText).getText();
        Assert.assertEquals(successLoggedInMessage, "You are logged in!");

        driver.findElementById(okButton).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(successTitle)));
    }

    @Test
    public void testFailedLogin() {
        // After open android app then verify the home page
        driver.findElementByXPath(homeTitle).isDisplayed();

        // Navigate to Login page
        driver.findElementByXPath(loginMenu).isDisplayed();
        driver.findElementByXPath(loginMenu).click();

        // Input invalid email and password, then login
        driver.findElementByXPath(loginTitle).isDisplayed();
        driver.findElementByXPath(fieldEmail).sendKeys("rookie");
        driver.findElementByXPath(fieldPassword).sendKeys("123123");
        driver.findElementByXPath(loginButton).click();

        // Failed login and got error
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(invalidEmail)));

        // Verify error invalid email
        String invalidEmailMessage = driver.findElementByXPath(invalidEmail).getText();
        Assert.assertEquals(invalidEmailMessage, "Please enter a valid email address");

        // Verify error invalid password
        String invalidPasswordMessage = driver.findElementByXPath(invalidPassword).getText();
        Assert.assertEquals(invalidPasswordMessage, "Please enter at least 8 characters");
    }
}
