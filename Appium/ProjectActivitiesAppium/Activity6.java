package ProjectActivitiesAppium;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity6 {
	AppiumDriver<MobileElement> driver = null;

@BeforeClass
public void beforeClass() throws MalformedURLException {
    // Set the Desired Capabilities
	DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
    caps.setCapability("platformName", "android");
    caps.setCapability("automationName", "UiAutomator2");
    caps.setCapability("appPackage", "com.android.chrome");
    caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
    caps.setCapability("noReset", true);

    // Instantiate Appium Driver
    URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
    driver = new AndroidDriver<MobileElement>(appServer, caps);
}
    @Test
	public void ChromeOne() throws IOException {
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  driver.get("https://www.training-support.net/selenium");
  	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Popups\"))")).click();
  	driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Sign In\"))")).click();
    }
    @Test
   public void testCaseOne() throws IOException {
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	  driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")).sendKeys("admin");
  	  driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")).sendKeys("password");
  	  driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")).click();
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	String loginSuccess = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
	  Assert.assertEquals(loginSuccess, "Welcome Back, admin");
	  System.out.println("Login Success");
    }
    
    @Test
    public void testCaseTwo() throws IOException {
    	  driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.widget.Button")).click();
    	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Popups\"))")).click();
    	  driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollIntoView(text(\"Sign In\"))")).click();
    	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	  driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[1]")).sendKeys("admin1");
      	  driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.EditText[2]")).sendKeys("password");
      	  driver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[2]/android.webkit.WebView/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View/android.widget.Button")).click();
      	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      	  String loginFailure = driver.findElementByXPath("//android.view.View[@resource-id='action-confirmation']").getText();
		  Assert.assertEquals(loginFailure, "Invalid Credentials");
		  System.out.println("Login Failed");  
  }    
    @AfterClass
    public void afterclass() {
  	  driver.quit();
    }

}
