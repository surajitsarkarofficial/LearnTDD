package com.afour.webui.commons;

import java.io.File;

public final class FrameworkConstants {

    private FrameworkConstants()
    {

    }

    public static final String resourcesPath = System.getProperty("user.dir")+ File.separator+
            "src"+ File.separator+"test"+ File.separator+"resources";

    public static final String dataPath = resourcesPath+ File.separator+"data";


    public static final int waitTime = 10;
}
