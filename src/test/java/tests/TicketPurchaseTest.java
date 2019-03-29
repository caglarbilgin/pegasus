package tests;

import android.TicketPage;
import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;

public class TicketPurchaseTest extends BaseTest {
    private WebDriverWait wait;

    @Before
    public void setUpDevice() throws MalformedURLException {
        setUp();
        driver = BaseTest.driver;
        wait = new WebDriverWait(driver, 60);
    }

    @org.junit.Test
    public void ticketPurchase() {
        TicketPage.ticket("Istanbul Tümü", "adana");
    }

    @After
    public void tearDownStep() throws IOException {
        super.tearDown();
    }
}
