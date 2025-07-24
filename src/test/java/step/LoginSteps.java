package step;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;


public class LoginSteps {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage = new LoginPage(driver);

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid username and password")
    public void userEntersValidCredentials() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @Then("User is redirected to the products page")
    public void userIsRedirectedToProductsPage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    }

    @When("User enters invalid username or password")
    public void userEntersInvalidCredentials() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();
    }

    @Then("Error message is displayed")
    public void errorMessageIsDisplayed() {
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
    }
}