package project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class E2E {
WebDriver driver;
String usename = "Rolex27@gmail.com";
String pass = "Rolex@28";
//String Title = "Automation Practice";

@BeforeClass    //Landing on the page 
public void setup() {
System.setProperty("webdriver.edge.driver", "C:\\Users\\RANGEESH BALAJI\\OneDrive\\Desktop\\Driver.folder\\msedgedriver.exe\\\\");
driver = new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://rahulshettyacademy.com/client");
}

@Test
public void e2e() {
driver.findElement(By.id("userEmail")).sendKeys(usename);
driver.findElement(By.id("userPassword")).sendKeys(pass);
driver.findElement(By.xpath("//input[@value='Login']")).click();
 String pagetitle = driver.getTitle();
 System.out.println(pagetitle);
}

@Test
public void orderselection() {
	
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.urlContains("dashboard"));
// Locate all card elements
List<WebElement> cards = driver.findElements(By.cssSelector(".card-body"));
// Iterate through the cards to find the one with "IPHONE 13 PRO"
for (WebElement card : cards) {
String cardText = card.getText();
System.out.println("Card Text: " + cardText); // Debugging output
if (cardText.contains("IPHONE 13 PRO")) {
System.out.println("Found the card with IPHONE 13 PRO!");
 // Perform an action, e.g., click on it
card.findElement(By.cssSelector(".btn")).click(); // Assuming there's a button inside the card
break; 
// Exit loop once the desired card is found
  }
  }
driver.findElement(By.xpath("//div[@class='product-buttons']//button[1]")).click();
driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
//driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")) ;
WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement button = waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-primary'])[3]")));
button.click();
}

@Test
public void payment() {
driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("001");
//Locate the input element
WebElement countryInput = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
//Enter partial text into the input field
countryInput.sendKeys("Ind");
//Wait for suggestions to load and select one
WebDriverWait cwait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement suggestion = cwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='India']")));
//Click on the suggestion
suggestion.click();
driver.findElement(By.xpath("//a[normalize-space(text())='Place Order']")).click();
WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement thankYouMessage = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));
// Print the text of the element
System.out.println(thankYouMessage.getText());
WebDriverWait orderwait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement OrderID = orderwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class='ng-star-inserted']")));
System.out.println(OrderID.getText());
}



@AfterClass
public void teardown() {
WebDriverWait signoutwait = new WebDriverWait(driver,Duration.ofSeconds(10));
WebElement signout = signoutwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[normalize-space(text())='Sign Out']")));
signout.click();
driver.quit();
}
}
