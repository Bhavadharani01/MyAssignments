package week7.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.get("https://www.leafground.com/waits.xhtml");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
    
//Wait for Visibility
    WebElement visible = driver.findElement(By.xpath("(//span[text()='Click'])[1]"));
    visible.click();
    //Explicit wait
    //create obj for webdriverwait
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    //wait till the element 
    wait.until(ExpectedConditions.visibilityOf(visible));
    //verification
    String text = driver.findElement(By.xpath("//span[text()='I am here']")).getText();
    System.out.println("1 Verified: "+text);
    
//wait for Invisibility
    WebElement invisible = driver.findElement(By.xpath("(//span[text()='Click'])[2]"));
    invisible.click();
    WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(30));
    WebElement button = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt93']"));
    wait.until(ExpectedConditions.invisibilityOf(button));
    String text2 = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).getText();
    System.out.println("After clickig: "+text2);
    if (text2.contains("I am about to hide")) {
		System.out.println("Not verified :(");
	} else {
		System.out.println("2 Verified!");
	}
    
//Wait for Clickability
    WebElement button1 = driver.findElement(By.xpath("//span[text()='Click Second']"));
   
    driver.findElement(By.xpath("//span[text()='Click First Button']")).click();
    WebDriverWait wait3=new WebDriverWait(driver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(button1));
    button1.click();
    
    System.out.println("3 Verified!");
    
//Wait for Text Change (1 - 10 Sec)
    String text3 = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt99']")).getText();
    System.out.println("Before Clickling: "+text3);
    
    driver.findElement(By.xpath("(//span[text()='Click'])[3]")).click();
    WebDriverWait wait4=new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//button[@id='j_idt87:j_idt99']"), "Did you notice?"));
    
    String text4 = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt99']")).getText();
    System.out.println("After Clickling: "+text4);
    
    if (text4.contains("Did you notice?")) {
   	System.out.println("4 Verified!");
	} else {
		System.out.println("Not verified :(");
	}
    
   driver.close();
    
}
}



