package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailPage {
	public WebDriver driver;

	public GmailPage(WebDriver driver) {
		this.driver = driver;
	}

	private By emailInput = By.xpath("//input[@id='identifierId']");
	private By nextBtn = By.xpath("//span[text()='Next']");
	private By passwordInput = By.xpath("//input[@type='password']");
	private By composeBtn = By.xpath("//div[@class='T-I T-I-KE L3']");
	private By toAddress = By.xpath("//input[@class='agP aFw']");
	private By subjectInput = By.xpath("//input[@name='subjectbox']");
	private By messageBody = By.xpath("//div[@aria-label='Message Body']");
	private By submitBtn = By.xpath("//div[text()='Send']");

	public void enterUserCredentails(String userName, String password) {
		driver.findElement(emailInput).sendKeys(userName);
		driver.findElement(nextBtn).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		ex.executeScript("arguments[0].value='" + password + "';", driver.findElement(passwordInput));
	}

	public void clickOnLoginBtn() {
		driver.findElement(nextBtn).click();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickOnComposeBtn() {
		driver.findElement(composeBtn).click();
	}

	public void typeInToField(String to) {
		driver.findElement(toAddress).sendKeys(to);
	}

	public void enterSubject(String subject) {
		driver.findElement(subjectInput).sendKeys(subject);
	}

	public void enterEmailBody(String body) {
		driver.findElement(messageBody).sendKeys(body);
	}

	public void clickSubmit() {
		driver.findElement(submitBtn).click();
	}

}
