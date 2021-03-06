package tests;

import android.LoginPage;
import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.net.MalformedURLException;


public class LoginTest extends BaseTest {
    private WebDriverWait wait;

    @Before
    public void setUpDevice() throws MalformedURLException {
        setUp();
        driver = BaseTest.driver;
        wait = new WebDriverWait(driver, 60);
    }

    @org.junit.Test
    public void loginTest() {

        LoginPage.loginApp("5542330602 ", "120304");
    }

    @org.junit.Test
    public void logout(){
        LoginPage.loginApp("5542330602","120304");
        LoginPage.logoutApp();
    }

    @After
    public void tearDownStep() throws IOException {
        super.tearDown();
    }


}
