package tests;

import base.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.Context;

import java.io.IOException;
import java.net.MalformedURLException;


public class Test extends BaseTest {
    private WebDriverWait wait;
    private Context context = new Context();

    @Before
    public void setUpDevice() throws MalformedURLException {
        setUp();

        driver = BaseTest.driver;
        wait = new WebDriverWait(driver, 60);



    }

    @org.junit.Test
    public void loginApp() {
        Context.clickButton("POPUPCLOSE");
        //enter the login page button xpath, comes through json file
        Context.clickButton("LOGINPAGE");
        //send value to username text area, comes through json file
        Context.inputText("USERNAMETEXT1", "554");
        Context.inputText("USERNAMETEXT2", "2330602");
        //send value to password, comes through json file
        Context.inputText("PASSWORDTEXT", "120304");
        //click login button xpath, comes through json file
        Context.clickButton("LOGINBUTTON");
    }

    @org.junit.Test
    public void ticketPurchase() {
        //click search cheap flight, comes through json file
        Context.clickButton("SEARCHCHEAPFLIGHT");
        //send value to 'FROM' text area, comes through json file
        Context.inputText("FROM", "istanbul");
        //check text of incoming element from json data, is it equal to expectedElement control
        Context.checkElementsTextEquals("FROM","Istanbul Tümü");
        //select istanbul, comes through json file
        Context.clickButton("ISTANBULTUMU");
        //send value to 'TO' from text area, comes through json file
        Context.inputText("TO", "adana");
        //check text of incoming element from json data, is it equal to expectedElement control
        Context.checkElementsTextEquals("TO","adana");
        //select adana, comes through json file
        Context.clickButton("ADANA");
        //click one-way button, comes through json file
        Context.clickButton("ONEWAY");
        //click calendar button, comes through json file
        Context.clickButton("CALENDAR");
        //select flight date from calendar
        Context.clickButton("FLIGHTDATE");
        //
        Context.clickButton("OKBUTTON");
        Context.clickButton("SEARCHFLIGHT");


    }

    @After
    public void tearDownStep() throws IOException {
        super.tearDown();
    }


}
