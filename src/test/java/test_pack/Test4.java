package test_pack;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class Test4 extends TestBefore {
    @Test
    public void checkPromoCodeTest() {
        StartPage page = new StartPage(driver);
        page.openCatalog();
        PromoCode promoCode = new PromoCode(driver);
        String elem1 = "Товары для ремонта";
        promoCode.clickElem(elem1);
        String elem2 = "Раковины";
        promoCode.clickElem(elem2);
        driver.get("https://beru.ru/catalog/rakoviny-umyvalniki/81826/list?hid=91614&track=fr_ctlg");
        ProductPage prodPage = new ProductPage(driver);
        int priceOne = 30000;
        prodPage.enterFirstPrice(priceOne);
        prodPage.showYet();
        prodPage.checkCountItemWithPrCode();
        prodPage.checkEmptyListItem();
        prodPage.addToBasketWithPrCode();
        prodPage.goToBasketWithPrCode();
        BasketPage basketPage = new BasketPage(driver);
        String prCode = "VODA1000";
        basketPage.inputPromoCode(prCode);
        String checkPrCode = "Скидка по промокоду";
        basketPage.checkPromoCode(checkPrCode);


    }
}