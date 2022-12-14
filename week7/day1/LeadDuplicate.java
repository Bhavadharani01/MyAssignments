package week7.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testcase.CommonClass;

public class LeadDuplicate extends ProjectSpecificationMethod{
	@BeforeTest
	public void openDB() {
		excelfile = "LeadDupliate";
	}
    @Test(dataProvider = "fetchdata")
	public void runDuplicatelead(String phnum) throws InterruptedException {
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		
}
//    @DataProvider(name = "duplicatelead")
//    public String[][] getData() throws IOException {
//  	  String [][] data = new String[2][1];
//  	  String[][] readdata = ReadExcel.readdata(excelfile);
//  	  return readdata;
//}
}
