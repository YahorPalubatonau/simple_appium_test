import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AppiumAppTest {

    private RemoteWebDriver driver = null;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
        cap.setCapability(MobileCapabilityType.APP, "/Applications/Tasker.apk");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void addTaskButtonVisibilityTest() {
        MobileElement addTaskButton = (MobileElement) driver.findElementById("com.theevilroot.tasker:id/add_task_view");
        assertEquals("ADD TASK", addTaskButton.getText());
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}