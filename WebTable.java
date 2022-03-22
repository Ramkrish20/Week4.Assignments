package week4.Assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://www.leafground.com/pages/table.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement table = driver.findElement(By.id("table_id"));
		List<WebElement> row = table.findElements(By.tagName("tr"));
		System.out.println("row count is "+row.size());
		List<WebElement> col = row.get(1).findElements(By.tagName("td"));
		System.out.println("column count is "+col.size());
		List<Integer> list = new ArrayList<Integer>();
		String leastProgress="";
		
		for(int i=1;i<row.size();i++) {
			WebElement eachRow = row.get(i);
			WebElement eachCol = eachRow.findElements(By.tagName("td")).get(0);
				if(eachCol.getText().equalsIgnoreCase("Learn to interact with Elements")) {
					System.out.println("Progress for Learn to interact with Elements is "+eachRow.findElements(By.tagName("td")).get(1).getText());
			}
				String text = eachRow.findElements(By.tagName("td")).get(1).getText();
				String substring = text.substring(0, text.length()-1);
				int parseInt = Integer.parseInt(substring);
				list.add(parseInt);
				Collections.sort(list);
				leastProgress = list.get(0).toString();
			
		}
			System.out.println("Least progress is  "+leastProgress+"%");
			WebElement vitalCheck = driver.findElement(By.xpath("//tr//td[contains(text(),'"+leastProgress+"')]//following::input[1]"));
			vitalCheck.click();
			boolean selected = vitalCheck.isSelected();
			System.out.println(selected);
		
		File screenshot = driver.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./images/WebTable.jpg");
		FileUtils.copyFile(screenshot, targetFile);
		}
	
}