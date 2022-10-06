package Marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("-disable-notiofications");
		ChromeDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://in.bookmyshow.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String title = driver.getTitle();
        System.out.println("The Title of the URL: "+title);
        driver.findElement(By.xpath("//img[@alt='HYD']")).click();
        String title2 = driver.getTitle();
        System.out.println("The title of the hydrebad URL: "+title2);
        driver.findElement(By.xpath("//span[text()='Search for Movies, Events, Plays, Sports and Activities']")).click();
        driver.findElement(By.xpath("(//a[@class='sc-lnrBVv bufhWn'])[3]")).click();
        Thread.sleep(3000);
        //driver.findElement(By.xpath("//div[text()[normalize-space()='07']]")).click()
        String name = driver.findElement(By.xpath("(//a[@class='__venue-name'])[3]")).getText();
        System.out.println("The first founded theatre name was: "+name);
        driver.findElement(By.xpath("(//img[@class='venue-info-icon lazy'])[3]")).click();
        Thread.sleep(3000);
        // Confirm if there is a parking facility in the theater
      //  String pop = driver.findElement(By.xpath("(//div[@class='venue-facility-item'])[4]")).getText();
        //System.out.println("The available facility is: "+pop);
        String text2 = driver.findElement(By.xpath("//div[text()='Available Facilities']")).getText();
        if(text2.contains("parking")) {
        	System.out.println("Parking facility is available in this theatre");
        }
        else {
        	System.out.println("Parking facility is not available in this theatre");
        }
        driver.findElement(By.xpath("//button[@id='wzrk-confirm']")).click();
       // Alert alert2 = driver.switchTo().alert();
        //alert2.accept();
        driver.findElement(By.xpath("//div[@class='heading-container']//div[2]")).click();
      //Click on the first green (available) timing
        driver.findElement(By.xpath("//a[@data-cat-popup='[{\"price\":\"150.00\",\"desc\":\"GOLD\",\"availabilityClass\":\"_available\",\"availabilityText\":\"Available\"}]']")).click();
     
       //Click Accept
        driver.findElement(By.xpath("//div[@class='bar-btn _primary']")).click();
        //driver.findElement(By.id("btnPopupAccept")).click();
      // Choose 1 Seat and Click Select Seats
        driver.findElement(By.xpath("//li[text()='1']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()[normalize-space()='Select Seats']]")).click();
        driver.findElement(By.xpath("//a[@class='_available']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[@id='btnSTotal_reserve']")).click();
        Thread.sleep(3000);
        String text = driver.findElement(By.className("__sub-total")).getText();
        System.out.println("The subtotal of the ticket: "+text);
        File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snaps/bookmyshow.png");
		FileUtils.copyFile(screenshotAs, dest);

	}

}
