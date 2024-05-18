package com.company.app.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormsTest extends BaseTest {
    String homeTitle = "//android.widget.TextView[@text=\"WEBDRIVER\"]";
    String formsMenu = "//android.widget.TextView[@text=\"Forms\"]";
    String formsTitle = "//android.widget.TextView[@text=\"Form components\"]";
    String inputFieldText = "//android.widget.TextView[@text=\"Input field:\"]";
    String inputField = "//android.widget.EditText[@content-desc=\"text-input\"]";
    String textResultTitle = "//android.widget.TextView[@text=\"You have typed:\"]";
    String textResult = "//android.widget.TextView[@content-desc=\"input-text-result\"]";
    String switchTitle = "//android.widget.TextView[@text=\"Switch:\"]";
    String switchButton = "//android.widget.Switch[@content-desc=\"switch\"]";
    String switchText = "//android.widget.TextView[@content-desc=\"switch-text\"]";
    String fieldDropdown = "//android.widget.EditText[@resource-id=\"text_input\"]";
    String dropdownText = "//android.widget.TextView[@text=\"Dropdown:\"]";
    String dropdownTitle = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Select an item...\"]";
    String dropdownListOne = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"webdriver.io is awesome\"]";
    String dropdownListTwo = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Appium is awesome\"]";
    String dropdownListThree = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"This app is awesome\"]";
    String activeButton = "//android.view.ViewGroup[@content-desc=\"button-Active\"]";
    String nonActiveButton = "//android.view.ViewGroup[@content-desc=\"button-Inactive\"]";
    String alertTitle = "android:id/alertTitle";
    String textButtonMessage = "android:id/message";
    String okButton = "android:id/button1";
    String cancelButton = "android:id/button2";
    String askMeLatterButton = "android:id/button3";

    @Test
    public void testFormScenario1() {
        // After open android app then verify the home page
        driver.findElementByXPath(homeTitle).isDisplayed();

        // Navigate to Forms page
        driver.findElementByXPath(formsMenu).isDisplayed();
        driver.findElementByXPath(formsMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formsTitle)));
        driver.findElementByXPath(formsTitle).isDisplayed();

        // Input text and verify the result
        driver.findElementByXPath(inputFieldText).isDisplayed();
        driver.findElementByXPath(inputField).sendKeys("forms1@99.co");
        driver.findElementByXPath(textResultTitle).isDisplayed();
        String inputResult = driver.findElementByXPath(textResult).getText();
        Assert.assertEquals(inputResult, "forms1@99.co");

        // Set switch to on
        driver.findElementByXPath(switchTitle).isDisplayed();
        driver.findElementByXPath(switchButton).click();
        String switchOn = driver.findElementByXPath(switchText).getText();
        Assert.assertEquals(switchOn, "Click to turn the switch OFF");

        // Choose content on dropdown field
        driver.findElementByXPath(dropdownText).isDisplayed();
        driver.findElementByXPath(fieldDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownTitle)));
        driver.findElementByXPath(dropdownListOne).click();
        String dropDownChosen = driver.findElementByXPath(fieldDropdown).getText();
        Assert.assertEquals(dropDownChosen, "webdriver.io is awesome");

        // Tap active button
        driver.findElementByXPath(activeButton).click();

        // Verify status button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alertTitle)));
        String buttonMessage = driver.findElementById(alertTitle).getText();
        Assert.assertEquals(buttonMessage, "This button is");
        String statusButton = driver.findElementById(textButtonMessage).getText();
        Assert.assertEquals(statusButton, "This button is active");

        // Tap ok on pop up message
        driver.findElementById(okButton).isDisplayed();
        driver.findElementById(cancelButton).isDisplayed();
        driver.findElementById(askMeLatterButton).isDisplayed();
        driver.findElementById(okButton).click();

        // Verify pop up message disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(alertTitle)));
    }

    @Test
    public void testFormScenario2() {
        // After open android app then verify the home page
        driver.findElementByXPath(homeTitle).isDisplayed();

        // Navigate to Forms page
        driver.findElementByXPath(formsMenu).isDisplayed();
        driver.findElementByXPath(formsMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formsTitle)));
        driver.findElementByXPath(formsTitle).isDisplayed();

        // Input text and verify the result
        driver.findElementByXPath(inputFieldText).isDisplayed();
        driver.findElementByXPath(inputField).sendKeys("Form2@99.co");
        driver.findElementByXPath(textResultTitle).isDisplayed();
        String inputResult = driver.findElementByXPath(textResult).getText();
        Assert.assertEquals(inputResult, "Form2@99.co");

        // Set switch still off
        driver.findElementByXPath(switchTitle).isDisplayed();
        driver.findElementByXPath(switchButton).isDisplayed();
        String switchOff = driver.findElementByXPath(switchText).getText();
        Assert.assertEquals(switchOff, "Click to turn the switch ON");

        // Choose content on dropdown field
        driver.findElementByXPath(dropdownText).isDisplayed();
        driver.findElementByXPath(fieldDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownTitle)));
        driver.findElementByXPath(dropdownListThree).click();
        String dropDownChosen = driver.findElementByXPath(fieldDropdown).getText();
        Assert.assertEquals(dropDownChosen, "This app is awesome");

        // Tap active button
        driver.findElementByXPath(activeButton).click();

        // Verify status button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alertTitle)));
        String buttonMessage = driver.findElementById(alertTitle).getText();
        Assert.assertEquals(buttonMessage, "This button is");
        String statusButton = driver.findElementById(textButtonMessage).getText();
        Assert.assertEquals(statusButton, "This button is active");

        // Tap ok on pop up message
        driver.findElementById(okButton).isDisplayed();
        driver.findElementById(cancelButton).isDisplayed();
        driver.findElementById(askMeLatterButton).isDisplayed();
        driver.findElementById(okButton).click();

        // Verify pop up message disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(alertTitle)));
    }

    @Test
    public void testFormScenario3() {
        // After open android app then verify the home page
        driver.findElementByXPath(homeTitle).isDisplayed();

        // Navigate to Forms page
        driver.findElementByXPath(formsMenu).isDisplayed();
        driver.findElementByXPath(formsMenu).click();
        WebDriverWait wait = new WebDriverWait(driver, 15); // Wait for 15 seconds
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formsTitle)));
        driver.findElementByXPath(formsTitle).isDisplayed();

        // Input text and verify the result
        driver.findElementByXPath(inputFieldText).isDisplayed();
        driver.findElementByXPath(inputField).sendKeys("f0rm3@99.co");
        driver.findElementByXPath(textResultTitle).isDisplayed();
        String inputResult = driver.findElementByXPath(textResult).getText();
        Assert.assertEquals(inputResult, "f0rm3@99.co");

        // Set switch to on
        driver.findElementByXPath(switchTitle).isDisplayed();
        driver.findElementByXPath(switchButton).click();
        String switchOn = driver.findElementByXPath(switchText).getText();
        Assert.assertEquals(switchOn, "Click to turn the switch OFF");

        // Choose content on dropdown field
        driver.findElementByXPath(dropdownText).isDisplayed();
        driver.findElementByXPath(fieldDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownTitle)));
        driver.findElementByXPath(dropdownListTwo).click();
        String dropDownChosen = driver.findElementByXPath(fieldDropdown).getText();
        Assert.assertEquals(dropDownChosen, "Appium is awesome");

        // Tap inactive button
        driver.findElementByXPath(nonActiveButton).click();

        // Verify pop up message status button not show
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(alertTitle)));
    }
}
