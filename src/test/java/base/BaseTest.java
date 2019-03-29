package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import tests.LoginTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    private static final String APPACTIVITY = "com.monitise.mea.pegasus.ui.splash.SplashActivity";
    private static final String APPPACKAGE = "com.pozitron.pegasus";
    public static DesiredCapabilities capabilities = new DesiredCapabilities();
    protected static final Logger log = Logger.getLogger(BaseTest.class);
    protected static AppiumDriver<MobileElement> driver;
    String ip = "http://0.0.0.0:4723/wd/hub";

    public void setUp() throws MalformedURLException{

        PropertyConfigurator.configure("properties/log4j.properties");
        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setPlatform(Platform.ANDROID);
        log.info("*** PLATFORM : " + capabilities.getCapability("PlatformName"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator");
        capabilities.setCapability("appPackage",APPPACKAGE);
        capabilities.setCapability("appActivity",APPACTIVITY);
        capabilities.setCapability("unicodeKeyboard",true);
        capabilities.setCapability("resetKeyboard",false);
        capabilities.setCapability("interKeyDelay",300);
        capabilities.setCapability(MobileCapabilityType.FULL_RESET,false);
        capabilities.setCapability(MobileCapabilityType.NO_RESET,true);
        capabilities.setCapability("autoGrantPermissions","true");
        driver = new AndroidDriver<MobileElement>(new URL(ip),capabilities);
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
    }
    public void tearDown() throws IOException {
        LoginTest.driver.quit();
    }
}
