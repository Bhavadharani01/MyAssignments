package week2.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment3 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();//setup path
		ChromeDriver driver = new ChromeDriver();//crt obj fr ChromeDriver
		driver.manage().window().maximize();//maximize window
		driver.get("http://leaftaps.com/opentaps/control/login"); //URL to launch
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Bhavadharani");
		driver.findElement(By.id("lastNameField")).sendKeys("S");
		driver.findElement(By.name("submitButton")).click();
		System.out.println(driver.findElement(By.id("viewContact_firstName_sp")).getText());
		System.out.println(driver.getTitle());
	    driver.close();
	}

}
