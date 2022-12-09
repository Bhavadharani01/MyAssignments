package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class Assignment5Nykaa {
public static void main(String[] args) throws InterruptedException {
	ChromeDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.nykaa.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	WebElement brand = driver.findElement(By.xpath("//a[text()='brands']"));
//	2) Mouseover on Brands and Search L'Oreal Paris
	Actions hover = new Actions (driver);
	hover.moveToElement(brand).perform();
	driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris");
//	3) Click L'Oreal Paris
	driver.findElement(By.xpath("(//a[contains(@href,'/brands/loreal-paris/c')])[1]")).click();
//	4) Check the title contains L'Oreal Paris(Hint-GetTitle)
	System.out.println("Title: "+driver.getTitle());
	String title = driver.getTitle();
	if (title.contains("L'Oreal Paris")) {
		System.out.println("Title Verified");
	} else {
        System.out.println("Title not matched");
	}
//	5) Click sort By and select customer top rated
	driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
	driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
//	6) Click Category and click Hair->Click haircare->Shampoo
	driver.findElement(By.xpath("//span[text()='Category']")).click();
	Thread.sleep(20);
	driver.findElement(By.xpath("//span[text()='Hair']")).click();
	Thread.sleep(20);
	driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
	Thread.sleep(20);
	driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
//	7) Click->Concern->Color Protection
	Thread.sleep(20);
	driver.findElement(By.xpath("//span[text()='Concern']")).click();
	Thread.sleep(20);
	driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
//	8)check whether the Filter is applied with Shampoo
	Thread.sleep(20);
	String filter = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
	if (filter.contains("Shampoo")) {
		System.out.println("Shampoo - Filter applied");
	} else {
        System.out.println("Shampoo - filter not applied");
	}
//	9) Click on L'Oreal Paris Colour Protect Shampoo
	Thread.sleep(20);
	driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect Shampoo')]")).click();
//	10) GO to the new window and select size as 175ml
	String wins = driver.getWindowHandle();
	Set<String> window = driver.getWindowHandles();
	List<String>lst = new ArrayList<String>(window);
	driver.switchTo().window(lst.get(1));
	System.out.println("New window title: "+driver.getTitle());
	driver.findElement(By.xpath("//select[@title='SIZE']")).click();
	driver.findElement(By.xpath("//option[text()='175ml']")).click();
//	11) Print the MRP of the product
	String MRP = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();
//	12) Click on ADD to BAG
	driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();
//	13) Go to Shopping Bag 
	driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
//	14) Print the Grand Total amount
	driver.switchTo().frame(0);
	Thread.sleep(20);
	String GrandTotal = driver.findElement(By.xpath("(//span[text()='Grand Total']/preceding::span)[14]")).getText();
	System.out.println("GrandTotal: "+GrandTotal);
//	15) Click Proceed
	driver.findElement(By.xpath("//span[text()='Proceed']")).click();
	driver.switchTo().defaultContent();
//	16) Click on Continue as Guest
	driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
//	17) Check if this grand total is the same in step 14
	String pricedetail = driver.findElement(By.xpath("//p[text()='₹259']")).getText();
	System.out.println("pricedetail: "+pricedetail);
	if (GrandTotal.equals(pricedetail)) {
		System.out.println("Grandtotal & Pricedetail are same");
	} else {
        System.out.println("Grandtotal & Pricedetail are not same");
	}
//	18) Close all windows
	driver.quit();
	
}
}