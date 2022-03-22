package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitDisappear {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://www.leafground.com/pages/disapper.html");
		//maximize window
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./images/BeforeElementDisappears.jpg");
		FileUtils.copyFile(screenshot, targetFile);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btn")));
		
		String text = driver.findElement(By.id("show")).getText();
		boolean contains = text.contains("Button is disappeared");
		if(contains) {
			System.out.println("button is disappeared");
		}
		File screenshot1 = driver.getScreenshotAs(OutputType.FILE);
		File targetFile1 = new File("./images/AfterElementDisappears.jpg");
		FileUtils.copyFile(screenshot1, targetFile1);

	}

}