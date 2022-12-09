package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.sukgu.Shadow;

public class OrderingMobile extends CommonClass{
	@Test
	public void runOrderingmobile() throws InterruptedException {
		
		dom.findElementByXPath("//div[contains(@class,'sn-polaris-tab can-animate')]").click();
		dom.findElementByXPath("//span[text()='Service Catalog']").click();
		Thread.sleep(2000);
		WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13']")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[7]")).click();
		driver.findElement(By.xpath("(//label[@class='radio-label'])[9]")).click();
		driver.findElement(By.xpath("//label[text()='No']")).click();
		WebElement data = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		data.click();
		Select da = new Select(data);
		da.selectByValue("500MB");
		driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
		Thread.sleep(2000);
		String verify = driver.findElement(By.xpath("//span[@aria-live='assertive']")).getText();
		if (verify.contains("Thank you, your request has been submitted")) {
			System.out.println("Your order is placed Successfully!");
		} else {
            System.out.println("You order is not placed");
		}
		System.out.println("Request Number: "+ driver.findElement(By.xpath("//a[@id='requesturl']")).getText());
		
	}
}
//1. Launch ServiceNow application
//2. Login with valid credentials username as admin and password as India@123
//3. Click-AllEnter Service catalog in filter navigator and press enter 
//4. Click on  mobiles
//5.Select Apple iphone6s
//6.Update color field to rose gold and storage field to 128GB
//7.Select  Order now option
//8.Verify order is placed and copy the request number