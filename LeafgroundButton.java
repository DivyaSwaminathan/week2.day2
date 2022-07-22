package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		//click button
		driver.findElement(By.id("home")).click();
		Thread.sleep(700);
		//travel back to button page
		driver.findElement(By.xpath("//h5[text()='Button']/following-sibling::img")).click();

		//get position
		Point location = driver.findElement(By.id("position")).getLocation();
		System.out.println("The position of the button is " + location);
		int x=driver.findElement(By.id("position")).getLocation().getX();
		System.out.println("The X coordinate : " + x);
		int y=driver.findElement(By.id("position")).getLocation().getY();
		System.out.println("The Y coordinate : " + y);

		//Find colour
		String color = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("The background clour of the button is " + color);

		//find size
		Dimension size = driver.findElement(By.id("size")).getSize();
		//System.out.println();
		int height = driver.findElement(By.id("size")).getSize().getHeight();
		int width = driver.findElement(By.id("size")).getSize().getWidth();
		System.out.println("Size of button " + size +" Height " + height + "," + "Width " + width);

	}

}
