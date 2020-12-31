package com.afour.webui.applications.google;

import com.afour.webui.basetest.BaseTest;
import com.afour.webui.managers.ActionManager;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class GoogleBaseTest extends BaseTest {

    @BeforeMethod
    public void beforeMethodSetup() throws IOException {
        ActionManager.launchApplication(GoogleConstants.URL);
    }


}
