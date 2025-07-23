package step;

import hooks.Hooks;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps {
    LoginPage login = new LoginPage(Hooks.driver);

    @Given("User is on login page")
    public void user_on_login_page() {
        Hooks.driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_credentials() {
        login.inputUsername("standard_user");
        login.inputPassword("secret_sauce");
        login.clickLogin();
    }

    @Then("User is redirected to the products page")
    public void redirected_to_products() {
        String url = Hooks.driver.getCurrentUrl();
        Assert.assertTrue(url.contains("inventory.html"));
    }
}
