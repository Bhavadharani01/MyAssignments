package week4.day2; //Assignment1

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chittorgarhStockMarket {
	public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.chittorgarh.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	2. Click on stock market
	driver.findElement(By.xpath("//a[@id='navbtn_stockmarket']")).click();
//	3. Click on NSE bulk Deals
	driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
//	    hint-(Table-2)
//	4. Get all the Security names
	
	  List<WebElement> row = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr")); 
	  System.out.println("Row count: "+ row.size()); 
	  List<WebElement> sname =driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr[1]//th[3]")); 
	  List<String> lst = new ArrayList<String>();
	  //System.out.println(sname.size());
	 System.out.println("All Security Name: "); 
	 for (int i = 1; i < row.size(); i++) {
	 String findElements = driver.findElement(By.xpath("(//table)[2]//tr["+i+"]/td[3]")).getText(); 
	 lst.add(findElements);
	 System.out.println(findElements);
	  } 
	 System.out.println("Security count with duplicate: "+lst.size());
	 // 5. Ensure whether there are duplicate Security names 
	 Set<String>set = new LinkedHashSet<String>(lst);	
	 System.out.println("Security count without duplicate: "+set.size());
	 
	 if (lst.size()==set.size()) { 
		System.out.println("No Duplicate security names present & not removed");
	} else {
       System.out.println("Duplicates removed &  Duplicates present in all security name.");
	}
	 
	  driver.close();
	 
	
	}
}

//5.
//WebElement ele1 = driver.findElement(By.xpath("(//table)[2]//tr[1]/td[3]"));
//System.out.println("ele1: "+ele1.getText()); 
//WebElement ele2 =driver.findElement(By.xpath("(//table)[2]//tr[2]/td[3]"));
//System.out.println("ele2: "+ele2.getText());
//if(ele1.getText().equals(ele2.getText())) {
//System.out.println("There are duplicates in Security name"); } 
//else {
//System.out.println("No duplicates in security name"); }

//*5*--------------------------
/*List<WebElement> securityNames = driver.findElements(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr"));

List<String>lstSecurity=new ArrayList<String>();

for (int i = 1; i < securityNames.size(); i++) {
	String names = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']//tr["+i+"]/td[3]")).getText();
	lstSecurity.add(names);
	//Print the Security names
	System.out.println(names);
	}
System.out.println("List"+lstSecurity.size());
//get the list into set
Set<String>setSecurity=new LinkedHashSet<String>(lstSecurity);
//to find the size
System.out.println(setSecurity.size());
if (lstSecurity.size()==setSecurity.size()) {
	
	System.out.println("dup not removed");
	
}
else {
	System.out.println("dup removed");
}*/

