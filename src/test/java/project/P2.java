package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class P2 {
WebDriver driver;
@BeforeClass
public void setup() {
System.setProperty("webdriver.edge.driver", "C:\\Users\\RANGEESH BALAJI\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
driver = new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.saucedemo.com/");
	
}
@Test
public void page1() throws Exception {
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
Thread.sleep(2500);
driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt")).click();
//driver.findElement(By.id("add-to-cart")).click();
Thread.sleep(2500);
driver.findElement(By.id("react-burger-menu-btn")).click();
}

@AfterClass
public void teardown() throws Exception {
driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
Thread.sleep(2800);
driver.quit();
}



}
