package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsandWindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.irctc.co.in/");
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
driver.findElement(By.xpath("//div[@id='corover-close-btn']/img")).click();
WebElement button = driver.findElement(By.xpath("//button[text()='OK']"));
button.click();
driver.findElement(By.xpath("//li[@id='flight']/a")).click();

Set <String> allwindows = driver.getWindowHandles();
List <String> currentwindow = new ArrayList<String>(allwindows);
String newwindow = currentwindow.get(1);
driver.switchTo().window(newwindow);

WebElement elementdropdown = driver.findElement(By.id("dropdown10"));
elementdropdown.click();

String oldwindow = currentwindow.get(0);
driver.switchTo().window(oldwindow).close();

	}

}