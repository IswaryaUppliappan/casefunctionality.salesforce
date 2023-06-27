package casefunctionality.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class DeleteCase {

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
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
        String expected_Result="Case \"00001150\" was deleted. Undo";
		Assert.assertEquals(actual_Result,expected_Result);

	}

}
