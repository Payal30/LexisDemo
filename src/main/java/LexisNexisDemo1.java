import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LexisNexisDemo1 {

	@Test
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.setProperty("webdriver.chrome.driver","C:/Users/r93834/Downloads/chromedriver_win32.exe");
		WebDriver driver = new ChromeDriver();
	
		//System.setProperty("webdriver.gecko.driver","C:/Users/r93834/Downloads/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//Open Google search engine
		driver.get("http://www.google.com");
		driver.manage().window().maximize();
		WebElement s= driver.findElement(By.name("q"));
		//Search from “LexisNexis”
		s.sendKeys("LexisNexis");
		s.submit();
		try {
		Thread.sleep(4000);
		}catch (InterruptedException e)
		{
			System.out.println("I was interrupted!");
            e.printStackTrace();
		}
		//find row from table then get link from that row from the search result 
		WebElement table  = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/table"));
				
		WebElement tableRow = table.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/table/tbody/tr[4]"));
				
		WebElement tableRowCell = tableRow.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/table/tbody/tr[4]/td[1]"));
		
		WebElement clickLink = tableRowCell.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/table/tbody/tr[4]/td[1]/div/span/h3/a"));
		
		//String value = tableRowCell.getText();
		//System.out.println("Value is =========>" + value);
		// Open the third link in the search result then  Return the page title
		clickLink.click(); 
		
		System.out.println("Title....=========>  " + driver.getTitle());
		
	}
}




