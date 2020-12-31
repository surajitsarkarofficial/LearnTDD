package com.afour.webui.applications.flightradar.pages;

import com.afour.webui.managers.ActionManager;
import com.afour.webui.managers.ExtentManager;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class contains locators and methods related to FlightSchedulePage
 * @author surajit.sarkar
 */
public class FlightSchedulesPage extends FlightRadarBasePage {

    public FlightSchedulesPage() {
        if (ActionManager.isElementDisplayed(closeBannerButton)) {
            closeBannerIfDisplayed();
        }
        ActionManager.waitForElementToBeVissible(arrivalHeader);
        ExtentManager.getInstance().getExtentTest().log(Status.INFO, "Navigated to Flight Schedules.");
    }

    @FindBy(xpath = "//label[contains(text(),'Arrivals')]")
    private WebElement arrivalHeader;

    @FindBy(xpath = "//label[contains(text(),'Arrivals')]/following-sibling::table")
    private WebElement arrivalTable;

    @FindBy(xpath = "//div[@class='important-banner__footer']/button[text()='Close']")
    private WebElement closeBannerButton;

    @FindBy(xpath = "//label[contains(text(),'Arrivals')]/following-sibling::table//tr[contains(@class,'hidden-xs') and contains(@class,'scope')]")
    private WebElement tableData;

    String fightStatusByOriginCity = "//tr[contains(@class,'hidden-xs') and contains(@class,'scope')]" +
            "//td/div[contains(@ng-show,'flight.airport.origin')]/span[contains(text(),'%s')]" +
            "/ancestor::tr[contains(@class,'hidden-xs')]/td//span[contains(@ng-bind-html,'statusMessage')]/parent::td";

    /**
     * This method will close the banner displayed on the landing page
     *
     * @return FlightSchedulesPage
     */
    public FlightSchedulesPage closeBannerIfDisplayed() {
        ActionManager.click(closeBannerButton);
        return this;
    }

    /**
     * This method will print the arrival details of the flights from origin cities
     * metioned in the list and will return false if none of the cities had flights
     *
     * @param originCityList
     * @return boolean
     */
    public boolean printFlghtsArrivalSchedule(List<String> originCityList) {
        ActionManager.scrollIntoView(arrivalHeader);
        ActionManager.waitForElementToBeVissible(tableData);
        boolean isDataFound = false;
        for (String city : originCityList) {
            String locator = String.format(fightStatusByOriginCity, city);
            List<WebElement> elements = arrivalTable.findElements(
                    By.xpath(locator));

            if (elements.size() == 0) {
                System.out.println(city + ": data not available.");
                ExtentManager.getInstance().getExtentTest().log(Status.INFO, city + ": data not available.");
            } else {
                isDataFound = true;
                for (WebElement element : elements) {
                    System.out.println(city + ": " + ActionManager.getElementText(element));
                    ExtentManager.getInstance().getExtentTest().log(Status.INFO, city + ": " + ActionManager.getElementText(element));
                }
            }

        }
        return isDataFound;
    }

}
