Feature: Gmail Compose and Send Email

  @gmail
  Scenario Outline: Compose and Send a Basic Email
    Given User navigates to the Gmail website
    When User enters valid email address "<email>" and password "<password>"
    And User clicks on login button
    Then User should get login successfully
    When User clicks on the compose button
    And User enters recipient email address "<receipientEmail>" into TO address field
    And User enters email subject "<subject>" into subject field
    And User enters email body "<emailBody>" into body of the email
    And User clicks on the send button
    Then Email should be Message sent successfully

    Examples: 
      | email                      | password    | receipientEmail         | subject                | emailBody            |
      | saikrishna238389@gmail.com | sai12345678 | muthumani1132@gmail.com | This is a test subject | This is a test email |

  Scenario: Send an Email with Attachments
    Given I am logged into my Gmail account
    When I click on the "Compose" button
    And I fill in the recipient's email address, subject, body of the email, and attach file(s)
    And I click on the "Send" button
    Then the email with attachments should be sent successfully
    And the recipient should receive the email with the attachments in their inbox

  Scenario: Send an Email with CC and BCC
    Given I am logged into my Gmail account
    When I click on the "Compose" button
    And I fill in the recipient's email address, subject, body of the email
    And I add email addresses in the CC and BCC fields
    And I click on the "Send" button
    Then the email should be sent successfully
    And the recipient and CC/BCC recipients should receive the email in their respective inboxes

  Scenario: Draft an Email
    Given I am logged into my Gmail account
    When I start composing an email
    And I fill in the recipient's email address, subject, and body of the email
    And I click on the "Save Draft" button
    Then the email draft should be saved successfully
    And I should be able to access the draft in the "Drafts" folder

  Scenario: Send an Email with HTML Content
    Given I am logged into my Gmail account
    When I click on the "Compose" button
    And I fill in the recipient's email address, subject, and body of the email with HTML content
    And I click on the "Send" button
    Then the email with HTML content should be sent successfully
    And the recipient should receive the email with HTML formatting applied
