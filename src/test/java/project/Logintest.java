package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Logintest {
WebDriver driver;
@Test
public void login() {
System.setProperty("webdriver.edge.driver", "C:\\Users\\RANGEESH BALAJI\\Downloads\\edgedriver_win64 (2)\\msedgedriver.exe");
driver = new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.saucedemo.com/");
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

}


}
