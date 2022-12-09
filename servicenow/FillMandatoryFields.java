package servicenow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.sukgu.Shadow;

public class FillMandatoryFields extends CommonClass{
	@Test
public void runFillmandatoryFields() throws InterruptedException {
	
	dom.findElementByXPath("//div[contains(@class,'sn-polaris-tab can-animate')]").click();
	Thread.sleep(2000);
	dom.findElementByXPath("//input[@id='filter']").sendKeys("knowledge", Keys.ENTER);
	dom.findElementByXPath("//mark[text()='Knowledge']").click();
			
	Thread.sleep(2000);
	WebElement frame = dom.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(frame);
	driver.findElement(By.xpath("//button[@type='button']")).click();
	
	driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_knowledge_base']")).click();
	
	Set<String> windowHandles = driver.getWindowHandles();
	List<String>lst = new ArrayList<String>(windowHandles);
	driver.switchTo().window(lst.get(1));
	
	driver.findElement(By.xpath("(//a[@role='button'])[4]")).click();
	driver.switchTo().window(lst.get(0));
	
	WebElement frame1 = dom.findElementByXPath("//iframe[@id='gsft_main']");
	driver.switchTo().frame(frame1);
	driver.findElement(By.xpath("//button[@id='lookup.kb_knowledge.kb_category']")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("(//div[@class='list-item arrow'])[4]")).click();
	driver.findElement(By.xpath("//span[text()='Java']")).click();
	driver.findElement(By.xpath("//button[@id='ok_button']")).click();
	
	driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("Creating new record");
	driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
	System.out.println("New Record is Created!");
	
	
	
}
}
//1. Launch ServiceNow application
//2. Login with valid credentials 
//3. Enter Knowledge  in filter navigator and press enter
//4. Create new Article 
//5.Select knowledge base as IT and category as IT- java and Click Ok
//6.Update the other mandatory fields
//7.Select the submit option