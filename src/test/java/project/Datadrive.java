package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Datadrive {
	WebDriver driver;
	File path = new File("C:\\Users\\RANGEESH BALAJI\\OneDrive\\Desktop\\Book1.xlsx");
	@BeforeClass
	public void setup() {
	System.setProperty("webdriver.edge.driver", "C:\\Users\\RANGEESH BALAJI\\OneDrive\\Desktop\\Driver.folder\\msedgedriver.exe\\\\");
	driver = new EdgeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	}
@Test
public void data() throws IOException  {
FileInputStream fis = new FileInputStream(path);
XSSFWorkbook Workbook = new XSSFWorkbook(fis);
XSSFSheet sheet = Workbook.getSheet("Sheet1");
for(int i=1;i<=sheet.getLastRowNum();i++) {
XSSFRow row = sheet.getRow(i);
XSSFCell UserNameCell = row.getCell(0); // First column for username
 String username = UserNameCell.getStringCellValue();
 System.out.println(username);
// Read password
 XSSFCell PasswordCell = row.getCell(1); // Second column for password
  String password = PasswordCell.getStringCellValue();
  System.out.println(password);
  driver.findElement(By.id("user-name")).sendKeys(username); // Enter username
  driver.findElement(By.id("password")).sendKeys(password); // Enter password
  driver.findElement(By.id("login-button")).click();
 //page validation after login
  if(driver.getCurrentUrl().contains("inventory.html")) {
	  System.out.println("Login successful for the UserName:"+username);
  } else {
	  System.out.println("Login failed for the UserName:"+username);
  }
  break;
}

}
@AfterClass
public void teardown() {
driver.findElement(By.id("react-burger-menu-btn")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-test='logout-sidebar-link']")));
logoutLink.click();
driver.quit();
	
}
}
