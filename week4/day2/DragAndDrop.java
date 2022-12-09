package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class DragAndDrop {
public static void main(String[] args) throws InterruptedException {
	ChromeDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.leafground.com/drag.xhtml");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	//Draggable
	WebElement source = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
	Actions build = new Actions(driver);
	System.out.println("Initial Location: "+source.getLocation());
	build.dragAndDropBy(source, 310, 0).perform();
	System.out.println("Destination Location: "+source.getLocation());
	
	//Droppable
	WebElement source1 = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
	WebElement destination1 = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
	build.dragAndDrop(source1, destination1).perform();
	System.out.println("Status: "+driver.findElement(By.xpath("//div[@id='form:drop_content']")).getText());
	
	//Draggable Columns
	Thread.sleep(1000);
	build.dragAndDrop(driver.findElement(By.xpath("//table//span[text()='Name']")), driver.findElement(By.xpath("//table//th[@id='form:j_idt94:j_idt99']"))).perform();
	
	driver.close();
}
}
