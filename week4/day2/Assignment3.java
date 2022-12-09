package week4.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Assignment3 {
	public static void main(String[] args) {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement lib1 = driver.findElement(By.xpath("((//table)[1]//tr[1])[2]//td[1]"));
		System.out.println("Library - "+ lib1.getText());
		WebElement jq1 = driver.findElement(By.xpath("((//table)[1]//tr[1])[2]//td[2]"));
		System.out.println("jQuery: "+jq1.getText());
		WebElement bs1 = driver.findElement(By.xpath("((//table)[1]//tr[1])[2]//td[3]"));
		System.out.println("Bootstrap: "+bs1.getText());
		WebElement m1 = driver.findElement(By.xpath("((//table)[1]//tr[1])[2]//td[4]"));
		System.out.println("Modernizr: "+m1.getText());
		
		WebElement lib2 = driver.findElement(By.xpath("((//table)[1]//tr[2])//td[1]"));
		System.out.println("Library - "+ lib2.getText());
		//row size
		List<WebElement> rowsize = driver.findElements(By.xpath("((//table)[1]//tr[2])//td"));
		//looping to print the data
		for (int i = 2; i < rowsize.size()+1; i++) {
			String value = driver.findElement(By.xpath("((//table)[1]//tr[2])//td["+i+"]")).getText();
			System.out.println(value);		
		}
		driver.close();
	}
}
