package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller extends CommonClass{
	@Test
public void runCreatenewCaller() throws InterruptedException {
	/*
	 * ChromeDriverManager.chromedriver().setup(); ChromeDriver driver = new
	 * ChromeDriver(); driver.get("https://dev68636.service-now.com");
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 * 
	 * driver.findElement(By.id("user_name")).sendKeys("admin");
	 * driver.findElement(By.id("user_password")).sendKeys("Y3Lfm$$oRE8l");
	 * driver.findElement(By.id("sysverb_login")).click(); Thread.sleep(3000);
	 * Shadow dom = new Shadow(driver); dom.setImplicitWait(30);
	 */
	dom.findElementByXPath("//div[contains(@class,'sn-polaris-tab can-animate')]").click();
	Thread.sleep(2000);
	dom.findElementByXPath("//input[@id='filter']").sendKeys("Callers", Keys.ENTER);
	Thread.sleep(2000);
	dom.findElementByXPath("//a[@class='nested-item item-label keyboard-navigatable highlighted-item']").click();
	Thread.sleep(2000);
	
	WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//button[@id='close-messages-btn']")).click();
	driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Bhavadharani");
	driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("S");
	driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("Creating new caller");
	//driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("bhavalskr@gmail.com");
	//driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("8123567843");
	//driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("8123567843");
	driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	Thread.sleep(1000);
	
	String text = driver.findElement(By.xpath("//div[@class='outputmsg_text']")).getText();
	if (text.contains("Bhavadharani")) {
		System.out.println("New caller created!");		
	} else {
		System.out.println("New caller not created");
	}
	
}
}
//1. Launch ServiceNow application
//2. Login with valid credential
//3. Click-All and Enter Callers in filter navigator and press enter 
//4. Create new Caller by filling all the fields and click 'Submit'.
//5. Search and verify the newly created Caller"