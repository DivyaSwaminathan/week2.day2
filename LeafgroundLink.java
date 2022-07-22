package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");


		driver.manage().window().maximize();
		//Click link
		driver.findElement(By.linkText("Go to Home Page")).click();
		//go to hyperlink again 
		Thread.sleep(700);
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();

		//where I am supposed to go
		String url1 = driver.findElement(By.xpath("//a[text()='Find where am supposed to go without clicking me?']")).getAttribute("href");
		System.out.println("The url that will be available on clicking the link is :  " + url1);

		//Verify if broken 
		String brokenLink =driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).getAttribute("href");
		driver.findElement(By.xpath("//a[text()='Verify am I broken?']")).click();
		Thread.sleep(700);
		String title = driver.getTitle();
		if(title.contains("404")) {
			System.out.println("The  broken link is " + brokenLink);

		}
		//interact with same link
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		String url = driver.findElement(By.xpath("//label[text()='(Interact with same link name)']/preceding-sibling::a")).getAttribute("href");
		String homeUrl = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).getAttribute("href");
		if (url.equals(homeUrl)) {
			System.out.println("The interactinf URL is same as Home URL");
		}
		else {
			System.out.println("The interacting URL is different from HOME URL");
		}

		//find number of links 
		List<WebElement> noOfLinks = driver.findElements(By.tagName("a"));
		System.out.println("The number of links in page : " + noOfLinks.size());



	}

}
