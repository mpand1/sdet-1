package ProjectActivitiesAppium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@Test
public class Activity2 {AppiumDriver<MobileElement> driver = null;

@BeforeClass
public void beforeClass() throws MalformedURLException {
    // Set the Desired Capabilities
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
    caps.setCapability("platformName", "android");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("appPackage", "com.google.android.keep");
    caps.setCapability("appActivity", ".activities.BrowseActivity");
    caps.setCapability("noReset", true);

    // Instantiate Appium Driver
    URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
    driver = new AndroidDriver<MobileElement>(appServer, caps);
   
}
public void CreateReminder() throws IOException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("com.google.android.keep:id/new_note_button")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  MobileElement title = driver.findElement(By.id("com.google.android.keep:id/editable_title"));
	  title.sendKeys("This is Appium Testing");
	  MobileElement note= driver.findElement(By.id("com.google.android.keep:id/edit_note_text"));
	  note.sendKeys("Testing is going on. Everything is great");
	  driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
	  
	  String titlePage= driver.findElement(By.id("com.google.android.keep:id/index_note_title")).getText();
	  String notePage= driver.findElement(By.id("com.google.android.keep:id/index_note_text_description")).getText();
	  Assert.assertEquals("This is Appium Testing", titlePage);
	  Assert.assertEquals("Testing is going on. Everything is great", notePage);
}
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  }