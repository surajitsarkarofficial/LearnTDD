package com.learn.webui.applications.google.pages;

import com.learn.webui.managers.ActionManager;
import com.learn.webui.managers.ExtentManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains the locators and method for Google Search Page
 *
 * @author surajit.sarkar
 */
public class SearchPage extends GoogleBasePage {

    public SearchPage() {
        ActionManager.waitForElementToBeVissible(searchBox);
        ExtentManager.getInstance().getExtentTest().log(Status.INFO, "Navigated to Google Search Page.");
    }


    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchResultsPage enterSearchText(String text) {
        ActionManager.enterText(searchBox, text + Keys.ENTER);
        return new SearchResultsPage();
    }


}
