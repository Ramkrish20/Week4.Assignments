package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitTextChange {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://www.leafground.com/pages/TextChange.html");
		//maximize window
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement button = driver.findElement(By.id("btn"));
		
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./images/BeforeTextChange.jpg");
		FileUtils.copyFile(screenshot, targetFile);
		
		wait.until(ExpectedConditions.textToBePresentInElement(button, "Click ME!"));
		
		File screenshot1 = driver.getScreenshotAs(OutputType.FILE);
		File targetFile1 = new File("./images/AfterTextChange.jpg");
		FileUtils.copyFile(screenshot1, targetFile1);
		
		button.click();
		
		wait.until(ExpectedConditions.alertIsPresent());
		
		String alertText = driver.switchTo().alert().getText();
		
		Assert.assertEquals(alertText, "Click ME!");

	}

}