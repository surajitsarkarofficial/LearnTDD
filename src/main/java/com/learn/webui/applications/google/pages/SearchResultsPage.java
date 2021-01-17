package com.learn.webui.applications.google.pages;

import com.learn.webui.managers.ActionManager;
import com.learn.webui.managers.ExtentManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class contains all the locators and methods related to google search results page
 *
 * @author surajit.sarkar
 */
public class SearchResultsPage extends GoogleBasePage {

    public SearchResultsPage() {
        ActionManager.waitForElementToBeVissible(searchResult);
        ExtentManager.getInstance().getExtentTest().log(Status.INFO, "Navigated to Google Search Results Page.");
    }

    @FindBy(css = "div.rc")
    private WebElement searchResult;

    @FindBy(xpath = "//div[@class='rc']//h3[contains(.,'Wikipedia')]/ancestor::div[@class='rc']/div[2]//span/span")
    private WebElement searchResultTextForWikipedia;

    public String getDescriptionTextForWikipediaResult() {
        ActionManager.scrollIntoView(searchResultTextForWikipedia);
        return ActionManager.getElementText(searchResultTextForWikipedia).replaceAll("[^\\x00-\\x7F]", "");
    }


}
