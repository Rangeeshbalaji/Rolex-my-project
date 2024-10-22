package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Functional {
WebDriver driver;

@BeforeClass
public void setup() {
System.setProperty("webdriver.edge.driver",  "C:\\Users\\RANGEESH BALAJI\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
driver= new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.saucedemo.com/");
}
@Test
public void login() throws Exception {
driver.findElement(By.id("user-name")).sendKeys("standard_user");	
driver.findElement(By.name("password")).sendKeys("secret_sauce");
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
}
@Test
public void pagecheck() {
String CurrentUrl = driver.getCurrentUrl();
if(CurrentUrl.contains("inventory.html")) {
	System.out.println("Login successful:"+CurrentUrl);
} else {
System.out.println("Login Failed");
}
}
@AfterClass
public void teardown() throws Exception {
driver.findElement(By.id("react-burger-menu-btn")).click();
Thread.sleep(3000);
driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
driver.quit();
}
}
