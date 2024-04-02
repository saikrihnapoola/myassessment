package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");

		String browser = browser_maven != null ? browser_maven : browser_properties;

		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(co);
			}
			if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get(url);
		}
		return driver;
	}

}
