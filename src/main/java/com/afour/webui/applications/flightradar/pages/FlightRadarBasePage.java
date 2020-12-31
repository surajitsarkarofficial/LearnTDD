package com.afour.webui.applications.flightradar.pages;

import com.afour.webui.managers.DriverManager;
import org.openqa.selenium.support.PageFactory;

/**
 * This is Base Page class for Flight Radar 24 applications.
 *
 * @author surajit.sarkar
 */
public class FlightRadarBasePage {

    public FlightRadarBasePage() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }


}
