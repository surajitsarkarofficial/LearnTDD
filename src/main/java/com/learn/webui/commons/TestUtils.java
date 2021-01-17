package com.learn.webui.commons;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class contains utility methods which can be used across the framework
 * @author surajit.sarkar
 */
public class TestUtils {

	/**
	 * This method will return the current date time in specified format
	 * @param format
	 * @return Stirng
	 */
	public static String getCurrentDateTime(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		return dateFormat.format(date);
	}

	/**
	 * This method will parse a json file and return the json object
	 * @param file
	 * @return JSONObject
	 */
	public static JSONObject parseJsonFile(String file) throws FileNotFoundException {
		InputStream is = new FileInputStream(new File(file));
		JSONTokener tokener = new JSONTokener(is);
		return new JSONObject(tokener);
	}
}
