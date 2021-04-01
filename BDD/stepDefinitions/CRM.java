package stepDefinitions;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CRM {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("^User opens the Mozilla FireFox Browser$")
    public void OpenFireFoxBrowser() throws Throwable {
        //Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver","C:\\Selenium Projects\\geckodriver-v0.29.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }
	@When("^Open the SuiteCRM page and login with credentials provided \"(.*)\" and \"(.*)\"$")
	public void OpenURLandLogin(String username, String password) throws Throwable {
		driver.get("https://alchemy.hguy.co/crm/index.php?action=Login&module=Users");
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("username_password")).sendKeys(password);
		driver.findElement(By.id("bigbutton")).click();	
	}
	@Given("^Count the number of Dashlets on the homepage$")
	public void countDashlets() throws Throwable {
		Thread.sleep(5000);
		List<WebElement> webletsCount = driver.findElements(By.className("dashlet-title"));
		System.out.println("The to number of weblets on the page are: " + webletsCount.size());
	}
	@When("^Print the number and title of each Dashlet into the console$")
	public void titleDashlets() throws Throwable {
		List<WebElement> dashletTitles = driver.findElements(By.className("dashlet-title"));
		for(WebElement dashletTitle : dashletTitles) {
		    System.out.println(dashletTitle.getText());
		}
	}
	@And("^Close the FireFox browser$")
	public void CloseFireFoxBrowser() throws Throwable{
		driver.quit();
	}
	
	@Given("^Navigate to Sales -> Leads -> Create Lead$")
	public void navigateToCretaeLeads() throws Throwable{
		Thread.sleep(5000);
		WebElement Leads = driver.findElement(By.id("grouptab_0")); 
		Actions actions = new Actions(driver);
		actions.moveToElement(Leads).perform();
		WebElement selectLeads = driver.findElement(By.id("moduleTab_9_Leads"));
		selectLeads.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/ul/li[1]/a/div[2]")).click();
		Thread.sleep(5000);
	}
	
	@When("^Fill in the necessary details to create lead accounts using the values passed from the Feature file as \"(.*)\" and \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void fillLeadsForms(String title, String Fname, String Lname, String eMail) throws Throwable {
		WebElement Title = driver.findElement(By.id("salutation"));  
		Select dropdown = new Select(Title); 
		dropdown.selectByVisibleText(title);
		driver.findElement(By.id("first_name")).sendKeys(Fname);
		driver.findElement(By.id("last_name")).sendKeys(Lname);
		driver.findElement(By.id("Leads0emailAddress0")).sendKeys(eMail);
	}
	
	@Then("^Click Save to finish$")
	public void SavetheLead() throws Throwable {
		driver.findElement(By.cssSelector("div.buttons:nth-child(5) > input:nth-child(1)")).click();
	}
	
	@And("^Navigate to the View Leads page to see results as \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void validateResult(String title, String Fname, String Lname) throws Throwable{
		Thread.sleep(5000);
		String leadname= driver.findElement(By.className("module-title-text")).getText();
		Assert.assertEquals(title + " " + Fname + " " + Lname, leadname);
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(5000);
		WebElement result= driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[3]/b/a"));
		Assert.assertEquals("Mr. Kiran Raj", result.getText());
	}	
	@Given("^Navigate to Activities -> Meetings -> Schedule a Meeting$")
	public void scheduleMeetingPage() throws Throwable{
		Thread.sleep(5000);
		WebElement Activities = driver.findElement(By.id("grouptab_3")); 
		Actions actions = new Actions(driver);
		actions.moveToElement(Activities).perform();
		WebElement meetings = driver.findElement(By.id("moduleTab_9_Meetings"));
		meetings.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[1]/ul/li[1]/a/div[2]")).click();
		Thread.sleep(5000);
	}
	@When("^Enter the details of the meeting$")
	public void fillMeetingDetails() throws Throwable{
		driver.findElement(By.id("name")).sendKeys("Testing JAVA Admin SDET");
		driver.findElement(By.id("description")).sendKeys("Testing in Progress. Wait for it.");
	}
	
	@Then("^Search for members and add them to the meeting with:$")
	public void SelectMembers(DataTable table) throws Throwable{
		List<List<String>> data  = table.asLists();
		System.out.println(data);
		driver.findElement(By.xpath("//*[@id=\"search_first_name\"]")).sendKeys(data.get(1).get(0));
		driver.findElement(By.id("invitees_search")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("invitees_add_1")).click();
		Thread.sleep(4000);
		WebElement firstName= driver.findElement(By.xpath("//*[@id=\"search_first_name\"]"));
		firstName.clear();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"search_first_name\"]")).sendKeys(data.get(2).get(0));
		driver.findElement(By.id("invitees_search")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("invitees_add_1")).click();
		Thread.sleep(4000);
		firstName.clear();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"search_first_name\"]")).sendKeys(data.get(3).get(0));
		driver.findElement(By.id("invitees_search")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("invitees_add_1")).click();
		Thread.sleep(4000);
	}
	@And("^Click On Save$")
	public void clickSave() throws Throwable{
		driver.findElement(By.id("SAVE_HEADER")).click();
	}
	@And("^Navigate to View Meetings page and confirm creation of the meeting$")
	public void NavigateBacktoMeetings() throws Throwable{
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("li.actionmenulinks:nth-child(3) > a:nth-child(1) > div:nth-child(2)")).click();
		Thread.sleep(5000);
		WebElement eVite= driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[4]/b/a"));
		Assert.assertEquals("Testing JAVA Admin SDET", eVite.getText());
	}
	@Given("^Navigate to All -> Products-> Create Product$")
	public void createProduct() throws Throwable{
		Thread.sleep(5000);
		WebElement All = driver.findElement(By.id("grouptab_5")); 
		Actions actions = new Actions(driver);
		actions.moveToElement(All).perform();
		WebElement products = driver.findElement(By.linkText("Products"));
		products.click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("li.actionmenulinks:nth-child(2) > a:nth-child(1) > div:nth-child(2)")).click();
		Thread.sleep(5000);
	}
	@When("^Retrieve information about the product as \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void productForm(String productName, String price, String description) throws Throwable{
		driver.findElement(By.id("name")).sendKeys(productName);
		driver.findElement(By.id("price")).sendKeys(price);
		driver.findElement(By.id("description")).sendKeys(description);
		Thread.sleep(5000);
	}
	@Then("^Click On Product Save Button$")
	public void clickSaveProduct() throws Throwable{
		driver.findElement(By.id("SAVE")).click();
		Thread.sleep(5000);
	}
	@And("^Go to the View Products page to see all products listed as \"(.*)\"$")
	public void validateProduct(String productName) throws Throwable{
		String titleProduct= driver.findElement(By.id("name")).getText();
		Assert.assertEquals(productName, titleProduct);
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/ul/li[2]/a/div[2]")).click();
		Thread.sleep(5000);
		String titleProductpage= driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/form[2]/div[3]/table/tbody/tr[1]/td[3]/b/a")).getText();
		Assert.assertEquals(productName, titleProductpage);	
	}
}