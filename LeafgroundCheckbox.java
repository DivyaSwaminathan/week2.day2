package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundCheckbox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		//select language
		driver.findElement(By.xpath("//label[text()='Select the languages that you know?']/following-sibling::input[1]")).click();

		//isChecked
		boolean selected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following-sibling::input")).isSelected();
		if(selected) {
			System.out.println("The checkbox is selected");}
		else {
			System.out.println("The checkbox is not selected");

		}
		//deselect only the selected 
		List<WebElement> deselectCheckboxescount = driver.findElements(By.xpath("//label[text()='DeSelect only checked']/following-sibling::input"));
		for(WebElement check :deselectCheckboxescount ) {
			if(check.isSelected()) {
				check.click();
			}
		}


		//multiple select 
		List<WebElement> noOfCheckboxes = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following-sibling::input"));
		for (WebElement webElement : noOfCheckboxes) {
			webElement.click();
		}

	}

}


