package week4.Assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//span[text()='From Contact']//following::a[1]")).click();
		
		Set<String> allwindowHandles = driver.getWindowHandles();
		List<String> currentwindow = new ArrayList<String>(allwindowHandles);
		String newwindow = currentwindow.get(1);
		driver.switchTo().window(newwindow);
		driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a")).click();
		driver.switchTo().window(currentwindow.get(0));
		driver.findElement(By.xpath("//span[text()='To Contact']//following::a[1]")).click();
		Set<String> allwindowHandles1 = driver.getWindowHandles();
		List<String> currentwindow1 = new ArrayList<String>(allwindowHandles1);
		String newwindow1 = currentwindow1.get(1);
		driver.switchTo().window(newwindow1);
		driver.findElement(By.xpath("//button[@class='x-btn-text']")).click();
				driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]/a")).click();
		driver.switchTo().window(currentwindow1.get(0));
		driver.findElement(By.linkText("Merge")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		if (driver.getTitle().contains("View Contact")) {
			System.out.println("Page Title Matches");
		}else {
			System.out.println("Page Title does not Match");
		}
		driver.close();
	}

}