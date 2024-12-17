package project;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VideoTest {
WebDriver driver;
//File path = new File("C:\\Users\\RANGEESH BALAJI\\OneDrive\\Desktop\\Book1.xlsx");
@BeforeClass
public void setup() {
System.setProperty("webdriver.edge.driver", "C:\\Users\\RANGEESH BALAJI\\OneDrive\\Desktop\\Driver.folder\\msedgedriver.exe\\\\");
driver = new EdgeDriver();
driver.get("https://videojs.com/sea");
driver.manage().window().maximize();
}
@Test
public void test() throws Exception {
EdgeOptions options = new EdgeOptions();
options.setCapability("logLevel", "TRACE");
driver = new EdgeDriver(options);

WebElement video = driver.findElement(By.tagName("video"));
JavascriptExecutor js = (JavascriptExecutor) driver;
// Play the video
js.executeScript("arguments[0].play();", video);
System.out.println("Playing the video...");
Thread.sleep(5000);

// Pause the video
js.executeScript("arguments[0].pause();", video);
System.out.println("Video paused.");

// Get the current playback time
Long currentTime = (Long) js.executeScript("return arguments[0].currentTime;", video);
System.out.println("Current playback time: " + currentTime + " seconds");
js.executeScript("arguments[0].muted = true;", video);
System.out.println("Video muted.");

// Unmute the video
js.executeScript("arguments[0].muted = false;", video);
System.out.println("Video unmuted.");

// Seek to 10 seconds
js.executeScript("arguments[0].currentTime = 10;", video);
System.out.println("Seeked to 10 seconds.");

}
@AfterClass
public void teardown() {
driver.close();
}
}
