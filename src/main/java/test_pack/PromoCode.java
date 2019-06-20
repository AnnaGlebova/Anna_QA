package test_pack;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PromoCode extends TestBefore{
    private WebDriver driver;

    public PromoCode(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход далее {0}")
    public void clickElem(String Elem) {
        WebElement forRepair = driver.findElement(By.linkText(Elem));
        forRepair.click();
    }
}
