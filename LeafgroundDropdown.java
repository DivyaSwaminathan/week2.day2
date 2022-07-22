package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		//select by Index
		WebElement byindex = driver.findElement(By.id("dropdown1"));
		Select drop1=new Select(byindex);
		drop1.selectByIndex(1);

		//select by text
		WebElement byText = driver.findElement(By.name("dropdown2"));
		Select drop2=new Select(byText);
		drop2.selectByVisibleText("Loadrunner");

		//select by value
		WebElement byValue = driver.findElement(By.id("dropdown3"));
		Select drop3=new Select(byValue);
		drop3.selectByValue("2");

		//get number of dropdowns
		List<WebElement> options = driver.findElements(By.xpath("//select[@class='dropdown']/option"));
		int number=options.size();
		System.out.println("The number of options avalable to choose from : " + number);

		Thread.sleep(300);
		//sendkeys to select
		driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select")).click();
		driver.findElement(By.xpath("//option[text()='You can also use sendKeys to select']/parent::select")).sendKeys("Selenium",Keys.ENTER);

		//select your programs
		driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='Selenium']")).click();
		driver.findElement(By.xpath("//option[text()='Select your programs']/following-sibling::option[text()='UFT/QTP']")).click();


	}

}
