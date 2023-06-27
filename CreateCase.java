package casefunctionality.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateCase {

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
		driver.findElement(By.xpath("//input[@class='slds-combobox_input slds-input slds-combobox_input-value']")).click();
		WebElement drop = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[1]"));
        drop.click();
        driver.findElement(By.xpath("//span[@title='Escalated']")).click();
        WebElement o = driver.findElement(By.xpath("(//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click'])[4]"));
        driver.executeScript("arguments[0].click();", o);
        driver.findElement(By.xpath("//span[@title='Email']")).click();
        WebElement l = driver.findElement(By.xpath("//input[@name='Subject']"));
        l.sendKeys("Testing");
        WebElement f = driver.findElement(By.xpath("(//textarea[contains(@class,'slds-textarea')])[1]"));
        f.sendKeys("Dummy");
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Case \"00001151\" was created.";
		Assert.assertEquals(actual_Result,expected_Result);

	}

}
