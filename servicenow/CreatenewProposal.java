package servicenow;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.sukgu.Shadow;

public class CreatenewProposal extends CommonClass{
	@Test
	public void runCreatenewProposal() throws InterruptedException {
	
		dom.findElementByXPath("//div[contains(@class,'sn-polaris-tab can-animate')]").click();
		Thread.sleep(2000);
		dom.findElementByXPath("//input[@id='filter']").sendKeys("Proposal", Keys.ENTER);
		dom.findElementByXPath("//span[@class='item-icon']").click();
		Thread.sleep(5000);
		WebElement findElement = dom.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(findElement);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000); 
		driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("Creating new incident");
		driver.findElement(By.xpath("//button[@id='sysverb_insert']")).click();
		Thread.sleep(2000);
		List<WebElement> rowsize = driver.findElements(By.xpath("//tbody[@class='list2_body']//tr"));
		System.out.println("rowsize: "+ rowsize.size());
		List<String>lst = new ArrayList<String>();
		for (int i = 1; i <= rowsize.size(); i++) {
			String text = driver.findElement(By.xpath("//tbody[@class='list2_body']//tr["+i+"]//td[4]")).getText();
			//System.out.println(lst.get(i));
			lst.add(text);
			if (lst.contains("Creating new incident")) { 
				System.out.println("New proposal is created");
			break;
			} 
			
		}
	
		}
}

//1. Launch ServiceNow application
//2. Login with valid credential 
//3. Click All and Enter Proposal in filter navigator and press enter 
//4. Click- new  and  fill mandatory fields and click 'Submit' Button.
//5. Verify the successful creation of new Proposal