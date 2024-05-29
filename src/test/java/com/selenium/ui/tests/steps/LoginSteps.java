package com.selenium.ui.tests.steps;

import com.selenium.ui.tests.DriverScript;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps {

  WebDriver driver;
  final String WEB_URL = "https://www.automationexercise.com/products";

  String loginEmail_textBox_Xpath = "//input[@data-qa='login-email']";
  String loginPassword_textBox_Xpath = "//input[@data-qa='login-password']";
  String loginButton_Xpath = "//button[@data-qa='login-button']";

  @Before
  public void setUp(Scenario scenario){

    DriverScript driverScript = new DriverScript();
    driver = driverScript.getDriver();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().implicitlyWait(Duration.of(30, ChronoUnit.SECONDS));
    driver.manage().window().maximize();
  }

  @After
  public void afterScenario(Scenario scenario){

    if(scenario.isFailed()){
      //we can take the screen shot and attach here
    }
    driver.quit();

  }
  @Given("The user on home page")
  public void the_user_on_home_page() {
    driver.get(WEB_URL);
    driver.findElement(By.className("fc-primary-button")).click();
  }

  @When("User click on Login or signUp")
  public void user_click_on_loginOrSignUp() {
    driver.findElement(By.partialLinkText("Login")).click();

  }
  @Then("User can see the login page")
  public void user_can_see_the_login_page() {
    WebElement emailTextBox = driver.findElement(By.xpath(loginEmail_textBox_Xpath));
    Assertions.assertTrue(emailTextBox.isDisplayed());
  }
  @Then("User enter the username as {string}")
  public void user_enter_the_username_as(String emailId) {
    driver.findElement(By.xpath(loginEmail_textBox_Xpath)).sendKeys(emailId);
  }
  @Then("User enter the password as {string}")
  public void user_enter_the_password_as(String password) {
    driver.findElement(By.xpath(loginPassword_textBox_Xpath)).sendKeys(password);
  }
  @When("User click on login button")
  public void user_click_on_login() {
    driver.findElement(By.xpath(loginButton_Xpath)).click();
  }
  @Then("User can see the dashboard page")
  public void user_can_see_the_dashboard_page() {
   String loggedInAsText =  driver.findElement(By.partialLinkText("Logged in as")).getText();
   Assertions.assertEquals(loggedInAsText,"Logged in as Suresh");
   Assertions.assertTrue(driver.findElement(By.partialLinkText("Logout")).isDisplayed());
  }

  }

