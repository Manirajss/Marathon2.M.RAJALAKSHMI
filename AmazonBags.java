package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonBags {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bags for boys",Keys.ENTER);
       // driver.findElement(By.xpath("(//div[@class='s-suggestion s-suggestion-ellipsis-direction'])[3]")).click();
        String result = driver.findElement(By.xpath("//span[text()='1-48 of over 30,000 results for']")).getText();
        System.out.println("the total number of results: "+result);
        driver.findElement(By.xpath("//i[@class='a-icon a-icon-checkbox']")).click();
        String reduce= driver.findElement(By.xpath("//span[text()='26 results for']")).getText();
        System.out.println("the results have got reduced: "+reduce);
        if(result!=reduce) {
        	System.out.println("Confirmed that the result had reduced");
        }
        driver.findElement(By.id("a-autoid-0-announce")).click();
        driver.findElement(By.id("s-result-sort-select_4")).click();
        String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
        System.out.println("first resulting bag price is: "+price);
        String discount = driver.findElement(By.xpath("//span[text()='(28% off)']")).getText();
        System.out.println("Discount of the bag: "+discount);
        driver.findElement(By.xpath("//img[@class='s-image']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String>lstWindow=new ArrayList<String>(windowHandles);
        driver.switchTo().window(lstWindow.get(1));
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/bags.png");
		FileUtils.copyFile(screenshotAs, dest);
        
		
	}

}
