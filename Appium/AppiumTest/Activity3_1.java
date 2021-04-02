package AppiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity3_1 {
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	@BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.mms");
        caps.setCapability("appActivity", ".ui.MmsTabActivity");
        caps.setCapability("noReset", true);
        
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }
  @Test
  public void smsTest() {
	// Locate the button to write a new message and click it
      driver.findElement(MobileBy.AndroidUIAutomator("description(\"Compose\")")).click();
      // Enter the number to send message to
      String contactBoxLocator = "resourceId(\"com.android.mms:id/recipients_editor\")";
      // Enter your own phone number
      driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("9845233117");
      
      // Focus on the message text box
      //String messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/hint_message\")";
      
      // Type in a message
      String messageBoxLocator = "resourceId(\"com.android.mms:id/embedded_text_editor\")";
      //driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.RelativeLayout/android.widget.EditText")).sendKeys("Hello from Appium");
      MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
      composeMessageInput.sendKeys("Hello from Appium");
      // Send the message
      driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send message\")")).click();
      // Wait for message to show
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_body")));
      // Assertion
      String messageLocator = "resourceId(\"com.android.mms:id/message_body\")";
      String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
      Assert.assertEquals(sentMessageText, "Hello from Appium");
  }
  

  @AfterClass
  public void afterClass() {
      driver.quit();
  }

}
