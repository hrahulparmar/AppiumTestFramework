package com.kwicon.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest extends DriverManager {

	@BeforeSuite
	public void testSetup() throws InterruptedException {
		DriverManager.startSession();
		System.out.println("Server Started");
	}

	@AfterSuite
	public void tearDown() {
		DriverManager.stopSession();
		System.out.println("Server Closed");
	}

	@BeforeMethod
	public void createDriver()
	{
		getDriver();
		System.out.println("Driver Created");
	}
	@AfterMethod
	public void destroyDriver()
	{
		quitdriver();
		System.out.println("Driver Quitted");
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}

		return destination;
	}
}
