package util;

import base.BaseTest;
import io.appium.java_client.MobileElement;
import mapping.MapMethodType;
import mapping.Mapper;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static mapping.Mapper.foundActivity;

public class Context extends BaseTest {


    public static void inputText(String by, String text) {
        log.info(text);
        WebDriverWait wait = new WebDriverWait(driver, 15);
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

}
