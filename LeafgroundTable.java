package week2.day2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		//number of rows 
		List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
		int rowNum=rows.size();
		System.out.println("The number of rows in the table: " + rowNum);
		//number of columns 
		 List<WebElement> columns  = driver.findElements(By.xpath("//tbody//th"));
		 int columnNum=columns.size();
		 System.out.println("the number of columns in the table : " +columnNum);
		//get progress value of learn to interact with Elements 
		 String text = driver.findElement(By.xpath("(//font[contains(text(),'Learn to interact')])[1]/following::font[1]")).getText();
		 System.out.println("The progress value for Lean to interact with elements is  " + text);
		 
		 
		//click on least progress value from the table 
		 List<WebElement> elements = driver.findElements(By.xpath("//input[@name='vital']/preceding::font[contains(text(),'%')]"));
		 int size=elements.size();
		 int str[]=new int[size];
		for (WebElement webElement : elements) {
			String temp=webElement.getText();
			temp=temp.replace("%","");
			for (int i=0;i<str.length;i++) {
			str[i]=Integer.parseInt(temp);
			
		}
		
		}
		Arrays.sort(str);
		int lp=str[0];
		String leastProgress=Integer.toString(lp);
		for (WebElement webElement : elements) {
			String temp=webElement.getText();
			if(temp.contains(leastProgress)) {
				System.out.println("The least progress value is " + temp);
				Thread.sleep(300);
				driver.findElement(By.xpath("//font[contains(text(),'"+temp+"')]/following::input")).click();
	
				}
			
	}
	}
	
}
		

	

