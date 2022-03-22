package week4.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsandFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
driver.manage().window().maximize();
driver.switchTo().frame(0);
driver.findElement(By.xpath("//button[text()='Try it']")).click();
Alert alert = driver.switchTo().alert();
System.out.println(alert.getText());
alert.accept();
driver.switchTo().defaultContent();
driver.switchTo().frame(0);
WebElement frametext = driver.findElement(By.id("demo"));
if (frametext.getText().contains("You pressed OK!")) {
	System.out.println("Alert Accepted");
	
}
 else 
{
	System.out.println("Alert Not Accepted");
}
}

}