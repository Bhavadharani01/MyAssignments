package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.codec.http.multipart.Attribute;

public class EditLead {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
	driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	driver.findElement(By.xpath("//div[@id='label']/a")).click();
		//* 6	Click Leads link
	driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//* 7	Click Find leads
	driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//* 8	Enter first name
	driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Bhavadharani");
		//* 9	Click Find leads button
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//* 10 Click on first resulting lead
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//a[text()='Bhavadharani'])[1]")).click();
		//* 11 Verify title of the page
	System.out.println(driver.getTitle());
		//* 12 Click Edit
	driver.findElement(By.xpath("//a[text()='Edit']")).click();
		//* 13 Change the company name
	driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).clear();
	driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("TC");
		//* 14 Click Update
	driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
	//* 15 Confirm the changed name appears
	String text = driver.findElement(By.xpath("//span[text()='TCS (12749)']")).getText();
	System.out.println(text);	
	
	
}
}
	
