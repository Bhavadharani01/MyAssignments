package week4.day2;//Assignment2

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment2 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//column count of table 1
		List<WebElement> column = driver.findElements(By.xpath("(//table)[1]//th"));
		System.out.println("No. of column in Table_1: "+column.size());
		//row count in table 1
		List<WebElement> row = driver.findElements(By.xpath("(//table)[1]//tr"));
		System.out.println("No. of row in Table_1: "+row.size());
		
		//column count of table 2
		List<WebElement> column2 = driver.findElements(By.xpath("(//table)[2]//th"));
		System.out.println("No. of column in Table_2: "+column2.size());
		List<WebElement> row2 = driver.findElements(By.xpath("(//table)[2]//tr"));
		System.out.println("No. of row in Table_2: "+row2.size());
		
		driver.close(); //close window
	}

}

 