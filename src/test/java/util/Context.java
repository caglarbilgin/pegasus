package util;

import base.BaseTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import mapping.MapMethodType;
import mapping.Mapper;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static mapping.Mapper.foundActivity;

public class Context extends BaseTest {


    public static void inputText(String by, String text) {
        log.info("text:" + text);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait until element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(foundActivity(MapMethodType.INPUT_ELEMENT, by)));
        MobileElement sendText = driver.findElement(Mapper.foundActivity(MapMethodType.INPUT_ELEMENT, by));
        sendText.sendKeys(text);

    }

    public static void clickButton(String button) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        //wait until element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(foundActivity(MapMethodType.CLICK_ELEMENT, button)));
        MobileElement clickButton = driver.findElement(Mapper.foundActivity(MapMethodType.CLICK_ELEMENT, button));
        clickButton.click();
    }

    public static void checkElementsTextEquals(String incomingElement, String expectedElement) {
        MobileElement element = driver.findElement(Mapper.foundActivity(MapMethodType.IS_ELEMENT, incomingElement));
        String elementText = element.getText().toLowerCase();
        try {
            Assert.assertEquals(elementText, expectedElement.toLowerCase());
            log.info(elementText + " ve " + expectedElement.toLowerCase() + " elementleri eşit");
        } catch (AssertionError e) {
            log.info(elementText + " ve " + expectedElement.toLowerCase() + " elementleri eşit değil");
        }
    }

    public static void swipeUpAccordingToPhoneSize() {
        int height = driver.manage().window().getSize().getWidth();
        int width = driver.manage().window().getSize().getHeight();

        int swipeStartWidth = width / 2;
        int swipeEndWidth = width / 2;

        int swipeStartHeight = (height * 70) / 100;
        int swipeEndHeight = (height * 30) / 100;
        TouchAction action = new TouchAction(driver);
        action.press(PointOption.point(swipeStartWidth,swipeStartHeight)).waitAction().moveTo(PointOption.point(swipeEndWidth,swipeEndHeight)).release().perform();
    }

    public static void swipeUpUntilSeeElement(String ticket) {
        for (int i = 0; i < 25; i++) {
            try {
                driver.findElement(foundActivity(MapMethodType.SELECT_ELEMENT, ticket)).isDisplayed();
                log.info(ticket + "element does not visible");
                break;
            } catch (Exception ex) {
                Context.swipeUpAccordingToPhoneSize();
            }
        }
    }
}


//**