package week2.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindZoomCars {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.zoomcar.com/in/bangalore");
		driver.manage().window().maximize();
		String currentUrl = driver.getCurrentUrl();
		if(currentUrl.equals("https://www.zoomcar.com/")) {
			//(//div[@class='multiselect__tags'])[1]
			driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[1]")).click();
			driver.findElement(By.xpath("//span[text()='India']")).click();
			driver.findElement(By.xpath("(//div[@class='multiselect__tags'])[2]")).click();
			driver.findElement(By.xpath("//span[text()='Bangalore']")).click();
			driver.findElement(By.xpath("//button[@class='city-lightbox__confirm-button']")).click();
		}
		driver.findElement(By.xpath("//div[contains(text(), 'Airport')]")).click();
		//Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//h3[contains(text(),'Suggested Pick Up Locations')]/following::i[1]")).click();
		driver.findElement(By.xpath("//span[@class='field-date start-time']")).click();
      
		driver.findElement(By.xpath("(//td[contains(text(),'29')])[1]")).click();
		driver.findElement(By.xpath("(//td[contains(text(),'29')])[1]")).click();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.END);
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		    
		driver.findElement(By.xpath("//button[contains(text(),'Find cars')]")).click();
		
		String price=driver.findElement(By.xpath("((//h3[contains(text(),'Maruti Swift Dzire')])[1]/following::div[@class='price-book-ctr']/div/div)[1]")).getText();
		System.out.println(price.replace("₹", "")); 

		/*File source = driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap1.dest1");
		//System.out.println(dest.getAbsolutePath());
		FileUtils.copyFile(source, dest); */

	}

}
