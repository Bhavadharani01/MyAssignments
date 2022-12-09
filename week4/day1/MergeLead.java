package week4.day1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeLead {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/login");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
//	 * 2. Enter UserName and Password Using Id Locator
	driver.findElement(By.id("username")).sendKeys("demosalesmanager");
	driver.findElement(By.id("password")).sendKeys("crmsfa");
//	 * 3. Click on Login Button using Class Locator
	driver.findElement(By.className("decorativeSubmit")).click();
//	Alert alert = driver.switchTo().alert();
//	String text = alert.getText();
//	System.out.println(text);
//	alert.accept();
//	 * 4. Click on CRM/SFA Link
	driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
//	 * 5. Click on contacts Button
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//	 * 6. Click on Merge Contacts using Xpath Locator
    driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
//	 * 7. Click on Widget of From Contact
    driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a")).click();
//	 * 8. Click on First Resulting Contact
    Set<String> windowHandle = driver.getWindowHandles();
    List<String>lst = new ArrayList<String>(windowHandle);
    driver.switchTo().window(lst.get(1));
    System.out.println("page title: "+driver.getTitle());
    driver.findElement(By.xpath("//a[@class='linktext']")).click();
    Thread.sleep(1000);
    //driver.close();
    driver.switchTo().window(lst.get(0));
//	 * 9. Click on Widget of To Contact
    driver.findElement(By.xpath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a")).click();
//	 * 10. Click on Second Resulting Contact
    Set<String> windowHandle2 = driver.getWindowHandles();
    List<String>lst1 = new ArrayList<String>(windowHandle2);
    driver.switchTo().window(lst1.get(1));
    System.out.println("page Title: "+driver.getTitle());
    driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
    Thread.sleep(1000);
    //driver.close();
    driver.switchTo().window(lst1.get(0));
//	 * 11. Click on Merge button using X-path Locator
    driver.findElement(By.xpath("//a[text()='Merge']")).click();
//	 * 12. Accept the Alert
    Alert alert2 = driver.switchTo().alert();
    String text2 = alert2.getText();
    System.out.println(text2);
    Thread.sleep(1000);
    alert2.accept();
//	 * 13. Verify the title of the page
	 String title = driver.getTitle();
	 System.out.println(title);
//   *close the chrome
	 driver.quit();
}
}







