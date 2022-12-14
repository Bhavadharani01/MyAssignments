package week7.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificationMethod {
	public ChromeDriver driver;
	String excelfile;
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void launchBrowser(String url,String uname, String pwrd) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwrd);
		driver.findElement(By.className("decorativeSubmit")).click();
	}
	@AfterMethod
	public void closeDriver() {
		driver.close();
	}
	@DataProvider(name= "fetchdata")
	   public String[][] getData() throws IOException {
		   String [][] readdata = ReadExcel.readdata(excelfile);  //[row][cols]
		   return readdata;


}
}