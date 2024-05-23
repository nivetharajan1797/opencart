package com.swayam.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.swayam.pages.HomePage;

public class TestBase {
	final static Logger Log = Logger.getLogger(HomePage.class.getName());
	public static Properties prop;
	static InputStream inputStream;

	static {
		prop = new Properties();
		try {
			File folder = new File("./resources/testdata");
			File[] fileNames = folder.listFiles();
			for (File file : fileNames) {
				inputStream = new FileInputStream(file);
				prop.load(inputStream);
			}
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void loadProp() {
		Log.info("====loading environment properties=======");
		InputStream inputStream2 = getClass().getClassLoader()
				.getResourceAsStream("environment.properties");
		try {
			prop.load(inputStream2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
