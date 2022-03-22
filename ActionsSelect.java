package week4.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSelect {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://www.leafground.com/pages/selectable.html");
		//maximize window
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		
		WebElement select = driver.findElement(By.id("selectable"));
		WebElement item1 = driver.findElement(By.xpath("//ol[@id='selectable']/li[1]"));
		WebElement item4 = driver.findElement(By.xpath("//ol[@id='selectable']/li[4]"));
		WebElement item6 = driver.findElement(By.xpath("//ol[@id='selectable']/li[6]"));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).click(item1).click(item4).click(item6).keyUp(Keys.CONTROL).build().perform();
	}

}