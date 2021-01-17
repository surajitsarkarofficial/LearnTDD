package com.learn.webui.applications.google.pages;
import com.learn.webui.managers.DriverManager;
import org.openqa.selenium.support.PageFactory;

public class GoogleBasePage {

    public GoogleBasePage() {
        PageFactory.initElements(DriverManager.getInstance().getDriver(), this);
    }
}
