package test_pack;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class Test2 extends TestBefore {
    @DataProvider(name = "cityName")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"Хвалынск"}, {"Самара"}, {"Уфа"}};
    }

    @Test(dataProvider = "cityName")
    public void changeCityTest(String cityName) {
        StartPage page = new StartPage(driver);
        page.clickCityInner();
        page.changeCityName(cityName);
        page.checkCityName();
        page.clickButtonAccount();
        LogIn loginForm = new LogIn(driver);
        String email = "anyutka.glebova@bk.ru";
        loginForm.enterLogin(email);
        String password = "vkontakte1998";
        loginForm.enterPassword(password);
        page.clickAddresses();
        Address address = new Address(driver);
        address.findCityInner();
        address.findDeliveryAddress();
        address.checkAdresses();
    }
}