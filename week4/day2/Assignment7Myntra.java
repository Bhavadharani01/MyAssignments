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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Assignment7Myntra {
	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ChromeDriver driver = new ChromeDriver(ch);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//		2) Mouse hover on MeN 
		WebElement Men = driver.findElement(By.xpath("(//a[@class='desktop-main'])[1]"));
		Actions builder = new Actions (driver);
		builder.moveToElement(Men).perform();
//		)
//		3) Click Jackets 
		driver.findElement(By.xpath("(//a[text()='Jackets'])[1]")).click();
		
//		4) Find the total count of item 
		String tc = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Total count of jacket: "+tc);
		
//		5) Validate the sum of categories count matches
		String jc = driver.findElement(By.xpath("(//span[@class='categories-num'])[1]")).getText().substring(1,6);
		System.out.println("category Jacket cout: "+jc);
        int a = Integer.parseInt(jc); 
	    String rjc = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]")).getText().substring(1, 3);
	    System.out.println("category Rain Jacket cout: "+rjc);
		int b = Integer.parseInt(rjc);
		int c = a+b;
		System.out.println("Total category count: "+ c);
		
		if (tc.equals(c)) {
			System.out.println("Total count & category count matched");
		}else
		{ System.out.println("Total count & category count not matched");
		}
		Thread.sleep(3000);				
//		6) Check jackets
		driver.findElement(By.xpath("(//label[@class='common-customCheckbox vertical-filters-label'])[1]")).click();
//		7) Click + More option under BRAND
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
//		8) Type Duke and click checkbox
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Duke",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
//		9) Close the pop-up x
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']")).click();
		Thread.sleep(2000);
		//Alert alert = driver.switchTo().alert();
	    //alert.accept();
//		10) Confirm all the Coats are of brand Duke
//		    Hint : use List 
	    List<WebElement> dukecoat = driver.findElements(By.xpath("//h3[@class='product-brand']"));
	    System.out.println("Duke Coat total count: "+ dukecoat.size());
        for (int i = 1; i < dukecoat.size(); i++) {
        	if (dukecoat.get(i).getText().contains("Duke")) {				
			}			
		}System.out.println("All are Duke brand coat");        
//		11) Sort by Better Discount
		WebElement findElement = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));
		Actions hover = new Actions (driver);
		hover.moveToElement(findElement).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
//		12) Find the price of first displayed item
		String fp = driver.findElement(By.xpath("(//span[@class='product-discountedPrice'])[1]")).getText();
		System.out.println("Price of first product: "+ fp);
//		Click on the first product
		driver.findElement(By.xpath("(//img[@draggable='false'])[4]")).click();
//		13) Take a screen shot
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		
		Thread.sleep(7000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/myntra.png");
		FileUtils.copyFile(screenshotAs, dest);
		
//		14) Click on WishList Now
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
//		15) Close Browser
        driver.quit();
	}
}
