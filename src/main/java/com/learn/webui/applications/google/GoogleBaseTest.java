package com.learn.webui.applications.google;

import com.learn.webui.basetest.BaseTest;
import com.learn.webui.managers.ActionManager;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

public class GoogleBaseTest extends BaseTest {

    @BeforeMethod
    public void beforeMethodSetup() throws IOException {
        ActionManager.launchApplication(GoogleConstants.URL);
    }


}
