package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;


public class Menu {
public static void main(String[] args) throws InterruptedException {
	ChromeDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/menu.xhtml?i=3#");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Menu Bar
	driver.findElement(By.xpath("//a[@class='ui-menuitem-link ui-submenu-link ui-corner-all']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='New']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//span[text()='Customer']")).click();
	
	//Context Menu
	WebElement right = driver.findElement(By.xpath("//h5[text()='Context Menu']"));
	Actions act = new Actions(driver);
	act.contextClick(right).pause(1000).perform();
   driver.findElement(By.xpath("(//span[@class='ui-menuitem-text'])[43]")).click();
   
	
    
	
}
}
