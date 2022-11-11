package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();//setup path
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notificatons");
		ChromeDriver driver = new ChromeDriver(ch);
		driver.get("https://login.salesforce.com/?locale=in");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']"));
		driver.findElement(By.xpath("//p[text()='Sales']"));
		driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.findElement(By.xpath("//div[text()='New']"));
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Bhavadharani");
		driver.findElement(By.xpath("//button[@data-value='Public']")).click();
	driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
	driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).click();
	if(attribute.contains("Bhavadharani")) {
		System.out.println("Account Created");
	}
	else
		System.out.println("Account not created");
	}
}