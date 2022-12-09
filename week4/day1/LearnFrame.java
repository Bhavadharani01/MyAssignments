package week4.day1;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click Me (Inside frame) 
		System.out.println("Click Me (Inside frame)");
		driver.switchTo().frame(0);
		WebElement element1 = driver.findElement(By.xpath("(//button[text()='Click Me'])[1]"));
		element1.click();
		String text = element1.getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		System.out.println("***************************************************"); 
		
		//Click Me (Inside Nested frame) 
		String text4 = driver.findElement(By.xpath("(//div[@class='card'])[3]")).getText();
		System.out.println(text4);//to print frame title
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		WebElement element2 = driver.findElement(By.xpath("//button[text()='Click Me']"));
		element2.click(); 
		String text2 = element2.getText();
		System.out.println(text2);
		driver.switchTo().defaultContent();
		System.out.println("***************************************************");
		
		//Total Framecount
              // Outer framecount
		 List<WebElement> outerframe = driver.findElements(By.tagName("iframe"));
		 System.out.println("Outer FrameCount: "+outerframe.size()); 
		 int outer = outerframe.size();
		     // Inner frame count
		 int inner = 0;
		  for (int i = 0; i < outerframe.size(); i++) {
		   driver.switchTo().frame(i);
		   List<WebElement> innerframe = driver.findElements(By.tagName("iframe"));
		   //System.out.println("Inner FrameCount: "+innerframe.size());
		   inner = innerframe.size();
		   //count = outer+innerframe.size();
		   driver.switchTo().defaultContent();
		  }
		  System.out.println("Inner FrameCount: "+ inner);
		 System.out.println("Total FrameCount: "+(outer+inner));
		driver.close();

		   
        
	}
}
