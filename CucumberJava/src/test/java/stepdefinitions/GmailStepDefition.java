package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GmailPage;
import utils.TestContextSetup;

public class GmailStepDefition {

	public WebDriver driver;
	public TestContextSetup testContextSetup;
	public GmailPage gmailPage;

	public GmailStepDefition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		gmailPage = testContextSetup.pageObjectManager.getGmailPage();
	}

	@Given("User navigates to the Gmail website")
	public void user_navigates_to_the_gmail_website() {
		System.out.println("Navigated sucessfully.");
	}

	@When("User enters valid email address {string} and password {string}")
	public void user_enter_valid_email_address_into_email_field(String email, String password) {
		gmailPage.enterUserCredentails(email, password);
	}

	@And("User clicks on login button")
	public void user_clicks_on_next_button() throws InterruptedException {
		gmailPage.clickOnLoginBtn();
	}

	@Then("User should get login successfully")
	public void user_should_get_login_successfully() {
		System.out.println("Logged in successfully");
	}

	@When("User clicks on the compose button")
	public void user_clicks_on_the_button() {
		gmailPage.clickOnComposeBtn();
	}

	@And("User enters recipient email address {string} into TO address field")
	public void user_enters_recipient_email_address_into_to_address_field(String to) {
		gmailPage.typeInToField(to);
	}

	@And("User enters email subject {string} into subject field")
	public void user_enters_email_subject_into_subject_field(String subject) {
		gmailPage.enterSubject(subject);

	}

	@And("User enters email body {string} into body of the email")
	public void user_enters_email_body_into_body_of_the_email(String body) {
		gmailPage.enterEmailBody(body);
	}

	@And("User clicks on the send button")
	public void user_clicksOnSendBtn() {
		gmailPage.clickSubmit();
	}

	@Then("Email should be Message sent successfully")
	public void email_should_be_message_sent_successfully() {
		System.out.println("Message Sent");
	}

}
