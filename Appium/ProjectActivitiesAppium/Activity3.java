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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity3 {AppiumDriver<MobileElement> driver = null;
WebDriverWait wait;


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

@Test

public void CreateReminder() throws IOException {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("com.google.android.keep:id/new_note_button")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  MobileElement title = driver.findElement(By.id("com.google.android.keep:id/editable_title"));
	  title.sendKeys("This is Appium Testing");
	  MobileElement note= driver.findElement(By.id("com.google.android.keep:id/edit_note_text"));
	  note.sendKeys("Testing is going on. Everything is great");
	  MobileElement reminder= driver.findElement(By.id("com.google.android.keep:id/menu_reminder"));
	  reminder.click();
	  driver.findElement(By.id("com.google.android.keep:id/save")).click();
	  driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
	  
	  String titlePage= driver.findElement(By.id("com.google.android.keep:id/index_note_title")).getText();
	  String notePage= driver.findElement(By.id("com.google.android.keep:id/index_note_text_description")).getText();
	  Assert.assertEquals("This is Appium Testing", titlePage);
	  Assert.assertEquals("Testing is going on. Everything is great", notePage);
	  
	 driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();
	 driver.findElement(By.id("com.google.android.keep:id/drawer_navigation_reminders")).click();
	 String titlePageReminder= driver.findElement(By.id("com.google.android.keep:id/index_note_title")).getText();
	 String notePageReminder= driver.findElement(By.id("com.google.android.keep:id/index_note_text_description")).getText();
	 Assert.assertEquals("This is Appium Testing", titlePageReminder);
	 Assert.assertEquals("Testing is going on. Everything is great", notePageReminder);
}
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  }