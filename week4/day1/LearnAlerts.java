package week4.day1;//Assignment 1

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		
		//Alert(Simple Dialog)
		System.out.println("Alert(Simple Dialog)");
		driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']")).click();
		Alert sa = driver.switchTo().alert();
		String text = sa.getText();
		System.out.println("Simple Alert: "+ text);
		sa.accept();
		//verify
		String text1 = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		System.out.println("Verification: "+text1);
		System.out.println("*****************************************************");
		
		//Alert(Confirmation Dialog)
		System.out.println("Alert(Confirmation Dialog)");
		driver.findElement(By.xpath("(//span[text()='Show'])[2]")).click();
		Thread.sleep(2000);
		Alert ac = driver.switchTo().alert();
		String text4 = ac.getText();
		System.out.println("Confirmation Alert: "+text4);
		ac.accept();
		String text41 = driver.findElement(By.xpath("//span[@id='result']")).getText();
		System.out.println(text41);
		System.out.println("*****************************************************");
		
		//Sweet Alert(Simple Dialog)
		System.out.println("Sweet Alert(Simple Dialog)");
		driver.findElement(By.xpath("(//span[text()='Show'])[3]")).click();
		Thread.sleep(2000);
		String text5 = driver.findElement(By.xpath("//p[contains(text(),'You have clicked and open a')]")).getText();
		System.out.println(text5);
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		System.out.println("*****************************************************");
		
		//Sweet Modal Dialog
		System.out.println("Sweet Modal Dialog");
		driver.findElement(By.xpath("(//span[text()='Show'])[4]")).click();
		Thread.sleep(2000); 
		String text6 = driver.findElement(By.xpath("(//div[@class='ui-dialog-content ui-widget-content'])[2]/p")).getText();
		System.out.println(text6);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		System.out.println("*****************************************************");
		
		//Alert(Prompt Dialog)
		System.out.println("Alert(Prompt Dialog)");
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		Alert pa = driver.switchTo().alert();
		String text2 = pa.getText();
		System.out.println("prompt alert: "+text2);
		pa.sendKeys("Bhavadharani");
		Thread.sleep(2000);
		pa.accept();
		String text21 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		System.out.println("verification: "+ text21);
		System.out.println("*****************************************************");
		
		//sweet Alert (confirmation)
		System.out.println("sweet Alert (confirmation)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String text3 = driver.findElement(By.xpath("//span[contains(text(),'Are you sure')]")).getText();
		System.out.println(text3);
		driver.findElement(By.xpath("//span[text()='No']")).click();
		System.out.println("*****************************************************");
		
		//Minimize and Maximize
		System.out.println("Minimize and Maximize");
		driver.findElement(By.xpath("(//span[text()='Show'])[6]")).click();
		String text7 = driver.findElement(By.xpath("//p[contains(text(),'I am Sweet Alert and can be')]")).getText();
		System.out.println(text7);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
		System.out.println("*****************************************************");
		driver.close();
	}

}
