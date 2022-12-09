package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHover {
	

	private static final org.openqa.selenium.OutputType<Object> OutputType = null;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement webElement = driver.findElement(By.linkText("Men's Fashion"));
		Actions builder = new Actions (driver);
		builder.moveToElement(webElement).perform();
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
	   File dest = new File("./snap/Mousehover.png");
	   FileUtils.copyFile(screenshotAs, dest);
	   driver.close();
	   
//		  File source = driver.getScreenshotAs(OutputType.FILE);//ctrl+2+l
//	        //step2:to save the file local dir
//	         File dest =new File("./snap/MouseHover.png");
//	         //step 3 join both source dest
//	         FileUtils.copyFile(source, dest);;
		
	}

}
//Load the url:https://www.snapdeal.com/
//Mousehover on Men's Fashion
//verify the page is loaded












 