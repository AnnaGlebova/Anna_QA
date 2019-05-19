package test_pack;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Test1 {
    @Test
    public void test() {
        //Указываем путь к драйверу
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("start-fullscreen");
        ChromeDriver driver = new ChromeDriver(options);


        // testContext.setAttribute("ScreenCreator", screen);
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

        driver.get("https://beru.ru");


        driver.findElement(By.className("header2-nav__user")).click();
        WebElement logInFotm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-login-form"))));


        logInFotm.findElement(By.name("login")).click();
        logInFotm.findElement(By.name("login")).sendKeys("anyutka.glebova@bk.ru");
        logInFotm.findElement(By.name("login")).sendKeys(Keys.ENTER);

        WebElement PassForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("passp-password-form"))));


        PassForm.findElement(By.name("passwd")).sendKeys("vkontakte1998" + "\n");

        WebElement note = driver.findElement(By.cssSelector("[class*='header2-nav__user']"));
        (new Actions(driver)).moveToElement(note).build().perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("[class*='user-menu__email']"))
                .getAttribute("textContent"), "anyutka.glebova@bk.ru");

        Assert.assertEquals(note.findElement(By.cssSelector("[class*='__text']")).getAttribute("textContent"),
                "Мой профиль");

        driver.quit();

    }
}
