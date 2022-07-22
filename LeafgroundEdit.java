package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundEdit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		//enter text
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		//append text
		String text = driver.findElement(By.xpath("//input[contains(@value,'Append')]")).getAttribute("value");
		text=text.concat("This is my new entry");
		//System.out.println(text);
		driver.findElement(By.xpath("//input[contains(@value,'Append')]")).clear();
		driver.findElement(By.xpath("//input[contains(@value,'Append')]")).sendKeys(text);
		//get default text
		String defaultText = driver.findElement(By.xpath("//label[text()='Get default text entered']/following-sibling::input")).getAttribute("value");
		System.out.println("The default text entered is :  " + defaultText);
		//clear text
		driver.findElement(By.xpath("//input[contains(@value,'Clear')]")).clear();
		//disabled or not 
		boolean enabled = driver.findElement(By.xpath("//label[text()='Confirm that edit field is disabled']/following-sibling::input")).isEnabled();
		System.out.println("Field Is Enabled ?: " + enabled);
	}

}
