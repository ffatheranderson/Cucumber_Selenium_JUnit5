package com.example.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {

	private static HelperClass helperClass;

	private static WebDriver driver;
	public final static int TIMEOUT = 10;

	private HelperClass() {
		// Set path to ChromeDriver
		System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");  // Run in headless mode
		options.addArguments("--no-sandbox"); // Disable sandboxing
		options.addArguments("--disable-dev-shm-usage"); // Overcome potential memory issues
		options.addArguments("--remote-allow-origins=*"); // Allow remote origins

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
		driver.manage().window().maximize();
	}

	public static void openPage(String url) {
		driver.get(url);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setUpDriver() {

		if (helperClass == null) {

			helperClass = new HelperClass();
		}
	}

	public static void tearDown() {

		if (driver != null) {
			driver.close();
			driver.quit();
		}

		helperClass = null;
	}

}