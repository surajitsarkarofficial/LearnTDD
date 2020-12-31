# **UI AUTOMATION MANUAL**

#### **TECH STACK**
1. Java 
2. Selenium
3. TestNG
4. ExtentNG Report
5. Maven

#### PRE-REQUISITES
1. Java 1.8 and above should be installed and configured.
2. Maven should be configured
3. Chrome browser and Firebox browser should be installed (Preferably latest version).

#### **FEATURES**
1. Supports web ui automation for multiple applications.
2. Supports Chrome and firefox browser.
3. Supports Parallel execution.
4. Extent Report is generated with ability to capture screenshots on test failure.
5. Data can be provided using JSON files.

#### **STEPS TO EXECUTE TESTS**
1. Execute via Command Line / Maven
    1. Launch command prompt.
    2. Go to the root folder of the project.
    3. Type the below command<br>
        **"mvn clean test -Dbrowser=Chrome"**<br>
        * valid values for browser is **Chrome or Firefox**.
        * If you do not wish to pass the browser then the default browser set is Chrome.
        * command to run in default browser is <br>
            * <b>mvn clean test </b>
            
2. Execute using the testng.xml
    1. Launch the project in preferred IDE.
    2. In the root folder, you can find the testng.xml.
    3. Default browser is set to Chrome.
        * If you wish to change the browser, you can do it by changing the value for the parameter named "browser" in the testng.xml file.
        * valid values for browser name are "Chrome" or "Firefox".
    4. Right click and select Run as TestNG.
    
#### **PARALLEL EXECUTION**
* By default parallel execution is set to **false**.
* If you wish to execute the tests in parallel, then follow below steps -
    * In the project root folder, edit the **testng.xml**
    * In the "<b>\<suite></b>" tag set the value for "**parallel**" attribute to "**tests**".
 
#### **REPORTS**
After the successful completion of test execution, The reports can be found in the **Reports** folder which is generated in the Project root directory.

            
