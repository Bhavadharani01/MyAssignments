package week7.day1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testcase.CommonClass;

public class CreateLead extends ProjectSpecificationMethod{

	@BeforeTest
    public void openDb() {
         excelfile="CreateLead";
    }
	
	   @Test(dataProvider="fetchdata")
		public void runCreatelead(String cname,String fname,String lname, String phnum) {
			
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phnum);
			driver.findElement(By.name("submitButton")).click();
		}
//	   @DataProvider(name= "createlead")
//	   public String[][] getData() throws IOException {
//		   String [][] readdata = ReadExcel.readdata("CreateLead");  //[row][cols]
//		   return readdata;
//	   }
	}
