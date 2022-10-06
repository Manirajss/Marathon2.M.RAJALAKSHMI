package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
        Thread.sleep(2000);
        
        driver.findElement(By.id("onward_cal")).click();
        
        driver.findElement(By.xpath("//table[@class='rb-monthTable first last']/tbody/tr[4]/td[5]")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		
		 String totbus = driver.findElement(By.xpath("//span[text()='92']")).getText();
		 System.out.println("Total number of bus found: "+totbus);
		 driver.findElement(By.xpath("//label[@for='bt_SLEEPER']")).click(); 
		 String secbus = driver.findElement(By.xpath("(//div[text()='Hail Trip'])[2]")).getText();
		 System.out.println("The name of the second resulting bus: "+secbus);
		 driver.findElement(By.xpath("(//div[text()='View Seats'])[2]")).click(); 
		 File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		 File dest=new File("./snaps/redbus.png");
		 FileUtils.copyFile(screenshotAs, dest);
		 
	}

}
