package test_pack;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogIn extends TestBefore {
    private WebDriver driver;

    public LogIn(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод логина")
    public void enterLogin(String login) {
        WebElement logInForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-login-form"))));
        WebElement logIn = logInForm.findElement(By.name("login"));
        logIn.click();
        logIn.sendKeys(login);
        logIn.sendKeys(Keys.ENTER);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        WebElement passwordForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".passp-password-form"))));
        WebElement passwordLine = passwordForm.findElement(By.name("passwd"));
        passwordLine.sendKeys(password);
        passwordLine.sendKeys(Keys.ENTER);
    }
}