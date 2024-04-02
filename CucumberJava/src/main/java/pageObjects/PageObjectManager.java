package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public GmailPage gmailPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public GmailPage getGmailPage() {
		gmailPage = new GmailPage(driver);
		return gmailPage;
	}

}
