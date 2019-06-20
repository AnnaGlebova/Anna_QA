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
        ProductPage prodPage = new ProductPage(driver);
        int price = 60000;
        prodPage.enterFirstPrice(price);
        prodPage.checkCountItem();
        prodPage.addToBasket();
        prodPage.goToBasket();
        BasketPage basketPage = new BasketPage(driver);
        String prCode = "VODA1000";
        basketPage.inputPromoCode(prCode);
        String checkPrCode = "Скидка по промокоду";
        basketPage.checkPromoCode();


    }
}