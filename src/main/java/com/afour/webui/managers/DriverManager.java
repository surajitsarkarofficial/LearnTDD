package com.afour.webui.managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * This class Manages the WebDriver Instance
 * @author surajit.sarkar
 */
public final class DriverManager {

    private DriverManager()
    {

    }
    private static DriverManager instance = new DriverManager();

    public static DriverManager getInstance()
    {
        return instance;
    }

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriver(WebDriver dr)
    {
        driver.set(dr);
    }

    public WebDriver getDriver()
    {
        return driver.get();
    }

    public void closeDriver()
    {
        getDriver().quit();
        driver.remove();

    }

    public void initDriver(String browser) throws Exception {
        switch (browser.toUpperCase())
        {
            case "CHROME" :
                WebDriverManager.chromedriver().setup();
                ChromeOptions chOptn = new ChromeOptions();
                chOptn.addArguments("--incognito");
                setDriver(new ChromeDriver(chOptn));
                break;

            case "FIREFOX" :
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions ffOptn = new FirefoxOptions();
                ffOptn.addArguments("--private");
                setDriver(new FirefoxDriver(ffOptn));
                break;

            default:
                throw new Exception("Unsupported browser. ABORT!!!");
        }
        getDriver().manage().window().maximize();
    }

}
