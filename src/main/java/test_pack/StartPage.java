package test_pack;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class StartPage extends TestBefore {
    private WebElement userButtonLog;
    private WebDriver driver;
    private WebElement regionElement;
    private String cityName;
    private List<WebElement> elements = null;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    private void findButtonAccount() {
        userButtonLog = driver.findElement(By.cssSelector(".header2-nav__user"));
    }

    @Step("Нажатие на кнопку \"Войти в аккаунт\"")
    public void clickButtonAccount() {
        findButtonAccount();
        userButtonLog.click();
    }

    @Step("Проверка имени пользователя")
    public void checkUserMenuEmail() {
        findButtonAccount();
        (new Actions(driver)).moveToElement(userButtonLog).build().perform();
        WebElement userMenuEmail = driver.findElement(By.cssSelector("[class*='user-menu__email']"));
        Assert.assertEquals(userMenuEmail.getAttribute("textContent"), "anyutka.glebova@bk.ru");
    }

    @Step("Проверка текста \"Мой профиль\" на кнопке")
    public void checkTextButtonAccount() {
        findButtonAccount();
        WebElement textButtonUser = userButtonLog.findElement(By.cssSelector("[class*='__text']"));
        Assert.assertEquals(textButtonUser.getAttribute("textContent"), "Мой профиль");
    }

    public void findCityInner() {
        regionElement = driver.findElement(By.cssSelector("[class*='__region'] [class*='__inner']"));
    }

    @Step("Нажатие на город")
    public void clickCityInner() {
        findCityInner();
        regionElement.click();
    }

    @Step("Смена города на {0}")
    public void changeCityName(String cityName) {
        this.cityName = cityName;
        WebElement CityForm = (new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class*='region-select-form']"))));
        //driver.findElement(By.cssSelector("[class*='region-select-form']"));
        WebElement enterCity = CityForm.findElement(
                By.cssSelector("[class*='region-suggest'] [class*='input__control']"));
        enterCity.click();
        enterCity.sendKeys(cityName);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(enterCity
                        .findElement(By.xpath("//strong[text()[contains(., \'" + cityName + "\')]]"))));
        enterCity.sendKeys(Keys.ENTER);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.invisibilityOf(driver
                        .findElement(By.cssSelector("[class*='suggestick-list']"))));
        enterCity.sendKeys(Keys.ENTER);
        driver.navigate().refresh();
    }

    @Step("Проверка названия текущего города")
    public void checkCityName() {
        findCityInner();
        Assert.assertEquals(regionElement.getAttribute("textContent"), cityName);
    }

    @Step("Переход на страницу с адресом доставки")
    public void clickAddresses() {
        findButtonAccount();
        (new Actions(driver)).moveToElement(userButtonLog).build().perform();
        WebElement addresses = driver.findElement(By.cssSelector("[class*='item_type_addresses']"));
        addresses.click();
    }

    @Step("Поиск {0}")
    public void findItem(String item) {
        // Находим электрические зубные щетки и переходим на страницу
        WebElement fieldForSearch = driver.findElement(By.id("header-search"));
        fieldForSearch.click();
        fieldForSearch.sendKeys(item);
        fieldForSearch.sendKeys(Keys.ENTER);
    }

    @Step("Переход далее")
    public void clickElem(String Elem) {
        WebElement forRepair = driver.findElement(By.linkText(Elem));
        forRepair.click();
    }


    @Step("Переход в каталог")
    public void openCatalog() {
        WebElement catalog = driver.findElement(By.cssSelector("[class *= 'button2']"));
        catalog.click();
    }
}
