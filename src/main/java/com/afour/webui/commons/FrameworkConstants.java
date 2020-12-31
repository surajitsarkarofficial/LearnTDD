package com.afour.webui.commons;

import java.io.File;

/**
 * This class contains all the constants which are common across the framework
 * @author surajit.sarkar
 */
public final class FrameworkConstants {

    private FrameworkConstants()
    {

    }

    public static final String resourcesPath = System.getProperty("user.dir")+ File.separator+
            "src"+ File.separator+"test"+ File.separator+"resources";

    public static final String dataPath = resourcesPath+ File.separator+"data";


    public static final int waitTime = 10;
}
