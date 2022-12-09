package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LearnTable {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://testleaf.herokuapp.com/pages/table.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//column|
	List<WebElement> column = driver.findElements(By.xpath("//table//tr[1]//th"));
	System.out.println("Column size: "+column.size());
	//row-
	List<WebElement> row=driver.findElements(By.xpath("//table//tr"));
	System.out.println("row size: "+row.size());
	//progress value
	String text = driver.findElement(By.xpath("//table//tr[3]//td[2]")).getText();
	System.out.println("the progress value of learn to interact element: "+text);
	
	//Check the vital task for the least completed progress.
	
	List<String>lst = new ArrayList<String>();
	for (int i = 1; i < row.size()+1; i++) {
		String value = driver.findElement(By.xpath("//table//tr["+i+"]//td[2]")).getText();
		lst.add(value);
		System.out.println(lst.get(i));
		Collections.sort(lst);
	}
	
	
	
	
}
}
//ClassRoom:
//Load Url:http://testleaf.herokuapp.com/pages/table.html
//Get the Row count
//Get the  



















