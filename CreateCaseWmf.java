package casefunctionality.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateCaseWmf {

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
		driver.findElement(By.xpath("//div[@title='New']")).click();
		WebElement r = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[3]"));
        driver.executeScript("arguments[0].click();", r);
		driver.findElement(By.xpath("//input[@class='slds-combobox__input slds-input slds-combobox__input-value']")).click();
		WebElement e = driver.findElement(By.xpath("(//div[contains(@class,'slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click')])[1]"));
		driver.executeScript("arguments[0].click();", e);
		driver.findElement(By.xpath("(//span[text()='--None--'])[1]")).click();
		WebElement l = driver.findElement(By.xpath("//input[@name='Subject']"));
        l.sendKeys("Testing");
        WebElement f = driver.findElement(By.xpath("(//textarea[contains(@class,'slds-textarea')])[1]"));
        f.sendKeys("Automation Testing");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        String actual_Error=driver.findElement(By.xpath("(//div[text()='Complete this field.'])[1]")).getText();
		String expected_Error= "Complete this field.";
	    Assert.assertEquals(actual_Error,expected_Error);
	    Assert.assertTrue(actual_Error.contains("Complete this field."));
	    String actual_Error1=driver.findElement(By.xpath("(//div[text()='Complete this field.'])[2]")).getText();
	  	String expected_Error1= "Complete this field.";
	  	Assert.assertEquals(actual_Error1,expected_Error1);
	  	Assert.assertTrue(actual_Error1.contains("Complete this field."));
	}

}
