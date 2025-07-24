package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    // Lokasi elemen-elemen yang kita butuhkan
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    // Constructor untuk inisialisasi driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Aksi-aksi yang bisa dilakukan
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(errorMessage).size() > 0;
    }
}
