package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
public class Facebook {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Bhavadharani");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("S");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Test@1234");
		// Step 11: Handle all the three drop downs-date
		WebElement Date = driver.findElement(By.id("day"));
		Select drop = new Select(Date);
		drop.selectByIndex(0);
		//month
		WebElement Month = driver.findElement(By.xpath("//select[@id='month']"));
		Select drop1 = new Select(Month);
		drop1.selectByValue("3");
		//year
		WebElement Year = driver.findElement(By.xpath("//select[@id='year']"));
		Select drop2 = new Select(Year);
		drop2.selectByVisibleText("2000");
		// Step 12: Select the radio button "Female" 
		           // ( A normal click will do for this step) 
        driver.findElement(By.xpath("//label[text()='Female']")).click();
		
	}

}
