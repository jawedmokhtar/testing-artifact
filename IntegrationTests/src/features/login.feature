Feature: Login test
    As a user in test
    I want to test if can login into automationpractice applications

    Scenario: open URL
        Given I open the url "http://automationpractice.com/index.php"
        Then  I expect that the url is "http://automationpractice.com/index.php"
        And   I expect that the title is "My Store"

    Scenario: Go to login page
        Given the page url is "http://automationpractice.com/index.php"
        When I click on the button ".login"
        Then I expect that the path is "/index.php?controller=authentication&back=my-account"
        And I expect that element "#email" is visible
        And I expect that element "#passwd" is visible
        And I expect that element "#SubmitLogin" is visible

    Scenario: login with fake credentials
        Given I open the url "http://automationpractice.com/index.php"
        And   I click on the button ".login"
        When  I log in to site with username "marketionist" and password "1234"
        Then  I expect that element "#center_column > div.alert.alert-danger > ol > li" is visible

    Scenario: Login with correct credentials
        Given I open the url "http://automationpractice.com/index.php"
        And   I click on the button ".login"
        When  I log in to site with username "jmores047@gmail.com" and password "manchester"
        Then  I expect that element "#center_column > div.alert.alert-danger > ol > li" is not visible


