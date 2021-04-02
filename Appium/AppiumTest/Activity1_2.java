package AppiumTest;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;

public class Activity1_2 {
	  AppiumDriver<MobileElement> driver = null;
@BeforeClass
  public void calc() throws InterruptedException, IOException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
      caps.setCapability("platformName", "android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.calculator");
      caps.setCapability("appActivity","com.android.calculator2.Calculator");
  try {
	// Initialize driver
      driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
      System.out.println("Calculator is open");
  } catch (MalformedURLException e) {
      System.out.println(e.getMessage());
  }
  }
  @Test
  public void Multiply()
  {
	  driver.findElementById("digit_7").click();
      driver.findElementById("op_mul").click();
      driver.findElementById("digit_4").click();
      
      // Perform Calculation
      driver.findElementById("eq").click();
      // Display Result
      String result = driver.findElementById("result_final").getText();
      System.out.println(result);
      Assert.assertEquals(result, "28");
	 
  }
@AfterClass
public void afterClass(){
	
	driver.quit();
	}
}