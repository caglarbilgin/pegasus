package tests;

import android.LoginPage;
import android.TicketPage;
import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Context;

import java.io.IOException;
import java.net.MalformedURLException;


public class Test extends BaseTest {
    private WebDriverWait wait;

    @Before
    public void setUpDevice() throws MalformedURLException {
        setUp();
        driver = BaseTest.driver;
        wait = new WebDriverWait(driver, 60);
    }

    @org.junit.Test
    public void loginTest() {
        LoginPage.loginApp("", "");
    }

    @org.junit.Test
    public void ticketPurchase() {
        TicketPage.ticket("Istanbul Tümü", "adana");
    }

    @org.junit.Test
    public void logout(){
        LoginPage.logoutApp();
    }

    @After
    public void tearDownStep() throws IOException {
        super.tearDown();
    }


}
