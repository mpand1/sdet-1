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

public class Activity2_3 {
	
	AppiumDriver<MobileElement> driver = null;
	WebDriverWait wait;
	
	@BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);
        
        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }
	
  @Test
  public void addContact() {
	// Click on add new contact floating button
      driver.findElementByAccessibilityId("Add").click();
      
      wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.EditText[@text='Name']")));
      
      // Find the first name, last name, and phone number fields
     MobileElement firstName = driver.findElementByXPath("//android.widget.EditText[@text='Name']");
     //MobileElement firstName = driver.findElementById("editors");
     //MobileElement firstName= driver.findElementByXPath("//android.widget.LinearLayout[@resource-id='editors']/android.widget.EditText");
      MobileElement phoneNumber = driver.findElementByXPath("//android.widget.EditText[@text='Phone']");
      // Enter the text in the fields
      firstName.sendKeys("Ash");
      phoneNumber.sendKeys("9900111761");
      // Save the contact
      driver.findElementByAccessibilityId("OK").click();
      // Wait for contact card to appear
      wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("title")));
      // Assertion
      MobileElement mobileCard = driver.findElementById("title");
      Assert.assertTrue(mobileCard.isDisplayed());
      String contactName = driver.findElementById("title").getText();
      Assert.assertEquals(contactName, "Ash");
  }
  

  @AfterClass
  public void afterClass() {
      driver.quit();
  }

}
