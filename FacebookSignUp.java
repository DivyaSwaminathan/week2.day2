package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignUp {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Divya");
		driver.findElement(By.name("lastname")).sendKeys("Swaminathan");
		driver.findElement(By.name("reg_email__")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Pass!12");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("abc@gmail.com");
		WebElement dropdown1=driver.findElement(By.xpath("//select[@id='day']"));
		
		Select day = new Select(dropdown1);
		day.selectByValue("7");
		WebElement dropdown2=driver.findElement(By.xpath("//select[@id='month']"));
		Select month= new Select (dropdown2);
		month.selectByVisibleText("Sep");
		WebElement dropdown3=driver.findElement(By.id("year"));
		Select year=new Select(dropdown3);
		year.selectByVisibleText("1990");
		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
