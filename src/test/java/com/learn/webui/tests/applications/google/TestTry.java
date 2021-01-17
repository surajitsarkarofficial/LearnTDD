package com.learn.webui.tests.applications.google;

import com.learn.webui.applications.google.GoogleConstants;
import com.learn.webui.commons.TestUtils;
import com.jayway.jsonpath.JsonPath;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class TestTry {

    public static void main(String[] args) throws IOException {
        JSONObject testData = TestUtils.parseJsonFile(GoogleConstants.JSON_PATH + File.separator + "try.json");

        //Using org.Json
        String name = testData.getJSONObject("data").getString("name");
        System.out.println(name);

        //Using JayWay JsonPath
        String name1 =JsonPath.read(testData.toString(),"data.name").toString();
        System.out.println(name1);


        //Using org.Json
        List<String> subjects = testData.getJSONObject("data").getJSONArray("subjects")
                .toList()
                .stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        subjects.forEach(System.out::println);

        //Using JayWay JsonPath
        List<String> subs = JsonPath.read(testData.toString(),"data.subjects");
        subs.forEach(System.out::println);

        int roll = Integer.parseInt(JsonPath.read(new File(GoogleConstants.JSON_PATH + File.separator + "try.json"),"data.roll").toString());
        System.out.println(roll);
    }
}
