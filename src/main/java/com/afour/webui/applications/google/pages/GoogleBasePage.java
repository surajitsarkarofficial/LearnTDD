package com.afour.webui.applications.google.pages;
import com.afour.webui.managers.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class GoogleBasePage {

    public GoogleBasePage() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }
}
