package com.afour.webui.tests.applications.flightradar;

import com.afour.webui.applications.flightradar.FlightRadarBaseTest;
import com.afour.webui.applications.flightradar.FlightRadarConstants;
import com.afour.webui.applications.flightradar.pages.FlightSchedulesPage;
import com.afour.webui.commons.TestUtils;
import com.afour.webui.managers.ExtentManager;
import com.aventstack.extentreports.Status;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author surajit.sarkar
 */
public class FlightRadarTests extends FlightRadarBaseTest {

    /**
     * The test will validate if the arrival flights details are being captured and printed
     */
    @Test
    public void printArrivalFlightsDetails() throws FileNotFoundException {
        JSONObject testData = TestUtils.parseJsonFile(FlightRadarConstants.JSON_PATH + File.separator + "originCity.json");
        List<String> cityList = testData.getJSONArray("city").toList().stream()
                .map( Object::toString )
                .collect( Collectors.toList() );
        boolean isDataPrinted = new FlightSchedulesPage().printFlghtsArrivalSchedule(cityList);
        Assert.assertTrue(isDataPrinted);
        ExtentManager.getInstance().getExtentTest().log(Status.PASS, "Flight arrivals printed successfully.");
    }
}
