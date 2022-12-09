package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.sukgu.Shadow;

public class CommonClass {
	public ChromeDriver driver;
	public Shadow dom;
   @BeforeMethod
	public void launchBrowser() throws InterruptedException {
	   ChromeDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev68636.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("user_password")).sendKeys("Y3Lfm$$oRE8l");
		driver.findElement(By.id("sysverb_login")).click();
		Thread.sleep(5000);
		
		dom = new Shadow(driver);
		dom.setImplicitWait(30);

	}
	
   @AfterMethod
	public void closeBrowser() {
	   driver.close();

	}
}

