
# End-to-End Testing of Demo E-Commerce Website

This project contains end-to-end Selenium tests for the [Rahul Shetty Academy](https://rahulshettyacademy.com/client) client website using Java, Selenium, and TestNG.

Tech Stack

Language: Java (JDK 8 or higher)

Automation Framework: Selenium WebDriver

Test Runner: TestNG

Browser: Microsoft Edge (via EdgeDriver)

## Test Overview

1. **Login**: Enter user credentials and log in.  
2. **Order Selection**: Select the product "IPHONE 13 PRO" and add it to the cart.  
3. **Payment**: Complete the payment process and print the order ID.  



## Test Scenarios Covered
The test suite validates the following user journeys:
1.	Login
User logs in with valid credentials.

2.	Product Selection
Browse the product dashboard.

Identify and select IPHONE 13 PRO.

Add the product to the cart.

3.	Checkout
Navigate to the cart.

Proceed with checkout.

4.	Payment & Order Confirmation
Enter CVV and select the country.

Place an order.

Verify Thank You message and retrieve Order ID.

5.	Logout
User signs out successfully.






## Getting Started
1. Prerequisites

Make sure you have the following installed:

Java JDK (8 or above)

Maven (for dependency management)

Microsoft Edge Browser

Edge WebDriver (matching your browser version)

## 📂 Source Code
```java
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

    @BeforeClass
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
        List<WebElement> cards = driver.findElements(By.cssSelector(".card-body"));
        for (WebElement card : cards) {
            String cardText = card.getText();
            if (cardText.contains("IPHONE 13 PRO")) {
                card.findElement(By.cssSelector(".btn")).click();
                break;
            }
        }
        driver.findElement(By.xpath("//div[@class='product-buttons']//button[1]")).click();
        driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = waiting.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-primary'])[3]")));
        button.click();
    }

    @Test
    public void payment() {
        driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("001");
        WebElement countryInput = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
        countryInput.sendKeys("Ind");
        WebDriverWait cwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement suggestion = cwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[normalize-space(text())='India']")));
        suggestion.click();
        driver.findElement(By.xpath("//a[normalize-space(text())='Place Order']")).click();
        WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement thankYouMessage = waiting.until(ExpectedConditions.visibilityOfElementLocated(By.className("hero-primary")));
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










