package com.learn.webui.applications.flightradar;

import com.learn.webui.basetest.BaseTest;
import com.learn.webui.managers.ActionManager;
import org.testng.annotations.*;

import java.io.IOException;

/**
 * @author surajit.sarkar
 * This is the base test class for the Flight Radar 24 application
 */
public class FlightRadarBaseTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() throws IOException {
        ActionManager.launchApplication(FlightRadarConstants.URL);
    }

}
