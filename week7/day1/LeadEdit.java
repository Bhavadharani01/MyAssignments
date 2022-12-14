package week7.day1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testcase.CommonClass;

public class LeadEdit extends ProjectSpecificationMethod{
	@BeforeTest
	public void openDB() {
		excelfile = "LeadEdit";
	}
    @Test(dataProvider = "fetchdata")
	public void runEditlead(String phnum, String cname) throws InterruptedException {
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phnum);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.name("submitButton")).click();
		
}
//    @DataProvider(name="editlead")
//    public String[][] getData() throws IOException {
//    String[][] readdata = ReadExcel.readdata("LeadEdit");
//    return readdata;
//    }
    
}