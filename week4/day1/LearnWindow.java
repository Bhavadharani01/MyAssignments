package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// To get active window
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
		// Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']")).click();
//		System.out.println(windowHandle);
//		System.out.println(driver.getTitle());//to slow the current window id(parent)
		
		// To go to 2nd widow
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Current no. of windows opened: "+windowHandles.size());
		
		List<String>lst = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lst.get(1));
		System.out.println("New 1st window id: "+driver.getWindowHandle());
		System.out.println("New 1st window Title: "+driver.getTitle());
		driver.close();
		
		// back to parent window
		Thread.sleep(2000);
		driver.switchTo().window(lst.get(0));
		System.out.println("came to parent "+driver.getTitle());
		
		// Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println("Current no. of windows opened: "+windowHandles2.size());
		// To close the newly opened tab
		List<String>lstwindow = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(lstwindow.get(1));
		System.out.println("New 2nd window id: "+driver.getWindowHandle());
		System.out.println("New 2nd window Title: "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(lstwindow.get(2));
		System.out.println("New 3rd window id: "+driver.getWindowHandle());
		System.out.println("New 3rd window Title: "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		
		//back to parent window
		driver.switchTo().window(lstwindow.get(0));
		System.out.println("came to parent "+driver.getTitle());
		
		// Close all windows except Primary
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		System.out.println("Currentno. of windows opened: "+windowHandles3.size());
		List<String>lstwindow1 = new ArrayList<String>(windowHandles3);
		driver.switchTo().window(lstwindow1.get(1));
		System.out.println("New 4th window id: "+driver.getWindowHandle());
		System.out.println("New 4th window Title: "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(lstwindow1.get(2));
		System.out.println("New 5th window id: "+driver.getWindowHandle());
		System.out.println("New 5th window Title: "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(lstwindow1.get(3));
		System.out.println("New 6th window id: "+driver.getWindowHandle());
		System.out.println("New 6th window Title: "+driver.getTitle());
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(lstwindow1.get(0));
		System.out.println("came to parent "+driver.getTitle());
		
		//Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles4 = driver.getWindowHandles();
		System.out.println("Currentno. of windows opened: "+windowHandles4.size());
		List<String>lstwindow4 = new ArrayList<String>(windowHandles4);
		driver.switchTo().window(lstwindow4.get(1));
		System.out.println("New 7th window id: "+driver.getWindowHandle());
		System.out.println("New 7th window Title: "+driver.getTitle());
		driver.close();
		driver.switchTo().window(lstwindow4.get(2));
		System.out.println("New 8th window id: "+driver.getWindowHandle());
		System.out.println("New 8th window Title: "+driver.getTitle());
		Thread.sleep(2000);
		driver.quit();// to close all opened window
		
		
		
		
	}
}
