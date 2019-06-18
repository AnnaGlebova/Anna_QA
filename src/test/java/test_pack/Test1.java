package test_pack;

import org.testng.annotations.*;

@Listeners(Listener.class)
public class Test1 extends TestBefore {
    @Test
    public void loginTest() {
        StartPage topPanel = new StartPage(driver);
        topPanel.clickButtonAccount();
        LogIn loginForm = new LogIn(driver);
        String email = "anyutka.glebova@bk.ru";
        loginForm.enterLogin(email);
        String password = "vkontakte1998";
        loginForm.enterPassword(password);
        topPanel.checkTextButtonAccount();
        topPanel.checkUserMenuEmail();
    }
}