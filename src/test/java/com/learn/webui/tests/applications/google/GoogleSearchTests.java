package com.learn.webui.tests.applications.google;

import com.learn.webui.applications.google.GoogleBaseTest;
import com.learn.webui.applications.google.GoogleConstants;
import com.learn.webui.applications.google.pages.SearchPage;
import com.learn.webui.commons.TestUtils;
import com.learn.webui.managers.ExtentManager;
import com.aventstack.extentreports.Status;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author surajit.sarkar
 */
public class GoogleSearchTests extends GoogleBaseTest {
    /**
     * This test will verify the description for wikipedia search result
     */
    @Test
    public void fetchWikiDescTest() throws FileNotFoundException {
        JSONObject testData = TestUtils.parseJsonFile(GoogleConstants.JSON_PATH + File.separator + "wikiText.json");
        String actualText = new SearchPage().enterSearchText(testData.getString("search-text"))
                .getDescriptionTextForWikipediaResult();
        String expectedText = testData.getString("expected-description").replaceAll("[^\\x00-\\x7F]", "");
        Assert.assertEquals(actualText, expectedText);
        ExtentManager.getInstance().getExtentTest().log(Status.PASS, "Description text is validated successfully.");
    }
}
