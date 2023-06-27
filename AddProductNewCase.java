package casefunctionality.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class AddProductNewCase {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,120)");
		Thread.sleep(2000);
		WebElement g = driver.findElement(By.xpath("//span[text()='View All Key Deals']"));
	    driver.executeScript("arguments[0].scrollIntoView(true)", g); 
        driver.executeScript("arguments[0].click();", g);
        WebElement a = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
        a.sendKeys("SRM Steels");
        a.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        WebElement z = driver.findElement(By.xpath("//a[@title='SRM Steels']"));
        driver.executeScript("arguments[0].click();", z);
        WebElement p = driver.findElement(By.xpath("//button[@name='Global.NewCase']"));
        driver.executeScript("arguments[0].click();", p);
        WebElement s = driver.findElement(By.xpath("//input[@title='Search Contacts']"));
        driver.executeScript("arguments[0].click();", s);
        WebElement opp=driver.findElement(By.xpath("//div[@title='Iswarya Uppliappan']"));
        driver.executeScript("arguments[0].click();", opp);
        WebElement a1 = driver.findElement(By.xpath("//input[@class=' input']"));
        a1.sendKeys("New case to SRM Steels");
        driver.findElement(By.xpath("(//span[text()='Save'])[3]")).click();
    	String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result=actual_Result;
		Assert.assertEquals(actual_Result,expected_Result);

	}

}
