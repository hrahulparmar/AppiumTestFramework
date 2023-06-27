package com.kwicon.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.digester.plugins.PluginManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.ServerArgument;

public class DriverManager {

	private static final String FILE_PATH = "./src/test/resources/properties/data.properties";
	private static final String APP_PATH = System.getProperty("user.dir") + "\\src\\test\\resources\\app\\Kwicon.apk";
	protected static AndroidDriver driver;
	private static AppiumServiceBuilder builder;
	private static AppiumDriverLocalService service;
	private static Properties properties;
	private static FileInputStream fileInputStream;

	public static void getConfig() {
		try {
			fileInputStream = new FileInputStream(FILE_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void startSession() throws InterruptedException {
		getConfig();
		startServer();
		Thread.sleep(5000);

	}

	public static AndroidDriver getDriver() {
		driver = (new AndroidDriver(service.getUrl(), setCapabilities()));
		setupDriverTimeouts();
		return driver;
	}

	public static void stopSession() {

		stopServer();
	}

	public static void quitdriver() {
		driver.quit();
	}

	public static void startServer() {
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1").usingPort(4723).usingAnyFreePort()
				.withAppiumJS(new File(properties.getProperty("appiumPath")))
				.usingDriverExecutable(new File(properties.getProperty("nodePath"))).withArgument(GeneralServerFlag.USE_PLUGINS,"element-wait")
				.withArgument(GeneralServerFlag.SESSION_OVERRIDE);

		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	private static DesiredCapabilities setCapabilities() {
		String emulator = properties.getProperty("emulator");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		if (emulator.equalsIgnoreCase("true")) {
			capabilities.setCapability("avd", properties.getProperty("deviceName"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, properties.getProperty("version"));
		}
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.APP, APP_PATH);
		capabilities.setCapability("noReset", false);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		capabilities.setCapability(MobileCapabilityType.UDID, properties.getProperty("udid"));

		return capabilities;
	}

	private static void setupDriverTimeouts() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public static void stopServer() {
		service.stop();
	}

}
