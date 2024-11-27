package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Mortage {
WebDriver driver;

@BeforeClass	
public void setup() {
System.setProperty("webdriver.edge.driver",  "C:\\Users\\RANGEESH BALAJI\\OneDrive\\Desktop\\Driver.folder\\msedgedriver.exe\\");
driver= new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.mortgagecalculator.org/");
}
@Test
public void cal() {
driver.findElement(By.id("homeval")).sendKeys("30000");
driver.findElement(By.id("loanamt")).sendKeys("6000");
driver.findElement(By.xpath("//*[@id=\"loanterm\"]")).sendKeys("20");
Select dropdown = new Select(driver.findElement(By.name("param[start_month]")));
dropdown.selectByIndex(10);
driver.findElement(By.id("start_year")).sendKeys("2024");
driver.findElement(By.cssSelector("input#pptytax")).sendKeys("2700");
driver.findElement(By.xpath("//input[@id='pmi']")).sendKeys("0.5");
driver.findElement(By.xpath("//input[@id='hoi']")).sendKeys("2400");
driver.findElement(By.id("hoa")).sendKeys("100");
Select loan = new Select(driver.findElement(By.name("param[milserve]")));
loan.selectByIndex(0);
Select loanselection = new Select(driver.findElement(By.name("param[refiorbuy]")));
loanselection.selectByVisibleText("Buy");
driver.findElement(By.xpath("//input[@type='submit']")).click();
String TotalPayement = driver.findElement(By.xpath("(//div[@class='left-cell']//h3)[1]")).getText();
System.out.println(TotalPayement);
}

@AfterClass
public void teardown() {
//driver.close();
driver.quit();
}
}
