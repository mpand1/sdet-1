package ProjectActivitiesAppium;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Activity1 {

    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Xiaomi Redmi Note 5 Pro");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }
  @Test
  public void CreateTask() throws IOException {
	  driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Tasks");
	  driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();
	  driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete Activity with Google Keep");
	  driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();
	  driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Complete the second Activity Google Keep");
	  driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();
	  List<MobileElement> actualtasks = driver.findElements(By.id("com.google.android.apps.tasks:id/task_name"));
	  Iterator<MobileElement> itr= actualtasks.iterator();
	  while(itr.hasNext()) {
		    System.out.println(itr.next().getText());
		}
		
	  String[] expectedtasks = {"Complete Activity with Google Tasks","Complete Activity with Google Keep","Complete the second Activity Google Keep"};
	  for (MobileElement ele: actualtasks){  
          for(int i=0;i<expectedtasks.length;i++){
              if(ele.getText().toLowerCase().equals(expectedtasks[i].toLowerCase())){
                  System.out.println("Matched ");
              }
          }
	  }
	  
  }
 
  @AfterClass
  public void afterTest() {
	  driver.quit();
  }

}
