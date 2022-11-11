package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
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
//		8	Click on Phone
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
//		9	Enter phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("1234567890");
//		10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//		11	Capture lead ID of First Resulting lead
		String text = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner x-grid3-col-part')]/a")).getText();
		System.out.println(text);
//		12	Click First Resulting lead
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Bhavadharani']")).click();
		//driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner x-grid3')]/a)[3]")).click();
//		13	Click Delete
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
//		14	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
//		15	Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys("10060");
//		16	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
//		17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String text2 = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(text2); 
		if (text2.contains("No records to display")) {
			System.out.println("Lead deleted successully");
		} else {
System.out.println("Lead not failed");
		}
//		18	Close the browser (Do not log out)
		driver.close();
	}

}
