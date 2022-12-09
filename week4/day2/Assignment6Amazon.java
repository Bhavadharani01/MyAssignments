package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
public class Assignment6Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("Price of first product: "+ price);
		String ratings = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("Number of customer ratings: "+ ratings);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-icon-star-small a-star-small')])[1]")).click();
//		Actions builder = new Actions (driver);
//		builder.moveToElement(findElement).perform();
//		Thread.sleep(2000);
		String percent = driver.findElement(By.xpath("(//span[@class='a-size-base'])[2]/a")).getText();
		System.out.println("the percentage of ratings for the 5 star: "+percent);
		
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		System.out.println("New window title: "+ driver.getTitle());
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		   File dest = new File("./snap/Newwindow.png");
		   FileUtils.copyFile(screenshotAs, dest);
		   Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		 Thread.sleep(9000);
		 
		 String subtotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText().substring(1);		
		 System.out.println("Subtotal: "+ subtotal);
		 //System.out.println("Actual subtotal"+ subtotal.substring(1));
		 if (subtotal.contains(price)) {
			System.out.println("Price & subtotal are same");
		} else {
            System.out.println("Price & subtotal are not same");
		}
		 driver.quit();
	}
}
//1.Load the uRL https://www.amazon.in/
//2.search as oneplus 9 pro 
//3.Get the price of the first product
//4. Print the number of customer ratings for the first displayed product
//5. Mouse Hover on the stars
//6. Get the percentage of ratings for the 5 star.
//7. Click the first text link of the first image
//8. Take a screen shot of the product displayed
//9. Click 'Add to Cart' button
//10. Get the cart subtotal and verify if it is correct.