package org.web.automation.library;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {

	public static String applicationConfigReader(String key) throws IOException {
		File f = new File("./ConfigurationFiles/ApplicationConfig.Properties");
		FileReader fr = new FileReader(f);
		Properties prop = new Properties();
		prop.load(fr);
		return prop.get(key).toString();

	}
	
	public static String elementConfigReader(String key) throws IOException {
		File f = new File("./ElementLocators/Locator.Properties");
		FileReader fr = new FileReader(f);
		Properties prop = new Properties();
		prop.load(fr);
		return prop.get(key).toString();

	}
}
