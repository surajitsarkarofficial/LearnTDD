package com.afour.webui.managers;

import com.afour.webui.commons.FrameworkConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

/**
 * This class contains the Selenium methods
 * @author surajit.sarkar
 */
public final class ActionManager {
    /**
     * This method will wait for element to be vissible
     *
     * @param ele
     */
    public static void waitForElementToBeVissible(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), FrameworkConstants.waitTime);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    /**
     * This method will wait for element to be clickable
     *
     * @param ele
     */
    public static void waitForElementToBeClickable(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance().getDriver(), FrameworkConstants.waitTime);
        wait.until(ExpectedConditions.elementToBeClickable(ele));
    }

    /**
     * Click on the element
     *
     * @param ele
     */
    public static void click(WebElement ele) {
        waitForElementToBeVissible(ele);
        waitForElementToBeClickable(ele);
        ele.click();
    }

    /**
     * Enter text
     *
     * @param ele
     * @param text
     */
    public static void enterText(WebElement ele, String text) {
        waitForElementToBeVissible(ele);
        ele.clear();
        ele.sendKeys(text);
    }

    /**
     * Launch the url
     *
     * @param url
     * @throws IOException
     */
    public static void launchApplication(String url) throws IOException {
        DriverManager.getInstance().getDriver().get(url);
    }

    /**
     * Scroll into view
     *
     * @param ele
     */
    public static void scrollIntoView(WebElement ele) {
        ((JavascriptExecutor) DriverManager.getInstance().getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", ele);

    }

    /**
     * Get element text
     *
     * @param ele
     * @return String
     */
    public static String getElementText(WebElement ele) {
        waitForElementToBeVissible(ele);
        return ele.getText();
    }

    /**
     * This method will return whether the element is displayed
     * @param ele
     * @return boolean
     */
    public static boolean isElementDisplayed(WebElement ele) {
        try {
            if (ele.isDisplayed()) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
