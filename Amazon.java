package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
driver.manage().window().maximize();
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
WebElement productprize = driver.findElement(By.className("a-price-whole"));
String Prize = productprize.getText();
System.out.println(Prize);

WebElement customerrating = driver.findElement(By.xpath("//a[@href='javascript:void(0)']//span[1]"));
System.out.println(customerrating.getText());
WebElement starrating = driver.findElement(By.xpath("(//span[@class='a-declarative'])[1]//i"));
starrating.click();
Actions actions = new Actions(driver);
actions.clickAndHold(starrating).perform();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
WebElement table = driver.findElement(By.id("histogramTable"));
List<WebElement> rows = table.findElements(By.tagName("tr"));
WebElement eachrow = rows.get(0);
System.out.println(eachrow.findElements(By.tagName("td")).get(2).getText());

driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
Set<String> allwindowHandles = driver.getWindowHandles();
List<String> allwindows = new ArrayList<String>(allwindowHandles);
String NewWindow = allwindows.get(1);
driver.switchTo().window(NewWindow);
driver.findElement(By.id("add-to-cart-button")).click();

Thread.sleep(5000);

 String cartprize = driver.findElement(By.xpath("//span[@class='currencyINR']")).getText();

	if (Prize.equalsIgnoreCase(cartprize)) {
		System.out.println("Prize is matching");
	}else {
		System.out.println("Prize is not Matching");
	}
	
	
	}

}