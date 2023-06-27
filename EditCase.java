package casefunctionality.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class EditCase {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement p = driver.findElement(By.xpath("//a[contains(@class,'slds-button slds-button_reset slds-context-bar__label-action')]"));
	    driver.executeScript("arguments[0].click();", p);
		WebElement c = driver.findElement(By.xpath("(//span[text()='Cases'])[2]"));
		driver.executeScript("arguments[0].click();", c);
		WebElement d = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
		d.click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement drop = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[1]"));
        drop.click();
        driver.findElement(By.xpath("//span[@title='Working']")).click();
        WebElement drop1 = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[2]"));
        drop1.click();
        driver.findElement(By.xpath("//span[@title='Low']")).click();
        WebElement drop2 = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[6]"));
        driver.executeScript("arguments[0].click();", drop2);
        driver.findElement(By.xpath("//span[@title='Phone']")).click();
        WebElement drop3 = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[10]"));
        driver.executeScript("arguments[0].click();", drop3);
        driver.findElement(By.xpath("//span[@title='No']")).click();
    	driver.findElement(By.xpath("//button[text()='Save']")).click();
    	 String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
 		String expected_Result="Case \"00001150\" was saved.";
 		Assert.assertEquals(actual_Result,expected_Result);
	}

}
