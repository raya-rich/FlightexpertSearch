package TicketBook;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TicketB {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.edge.driver",
				"D:\\Program Files\\chromedriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://flightexpert.com/");
		Thread.sleep(5000);
		driver.findElement(By.id("roundtrip")).click();
		driver.findElement(By.xpath("//li[text()='Student Fares']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Enter email address']"))
				.sendKeys("2018100000003@seu.edu.bd");
		String password = "A11wow";
		driver.findElement(By.cssSelector("#password")).sendKeys(password);
		WebElement checkbox = driver.findElement(By.id("remember-me"));
		// check if the checkbox is already selected
		boolean isChecked = checkbox.isSelected();
		// print the initial statep
		System.out.println("Initial state of the checkbox: " + (isChecked ? "Checked" : "Unchecked"));
		// if the checkbox is not checked, click on it
		if (!isChecked) {
			checkbox.click();
			System.out.println("Checkbox was unchecked and clicked to check.");
		} else {
			System.out.println("Checkbox is already checked. No action needed.");
		}

		driver.findElement(By.className("Sign-in-btn")).click();
		// select destination route
		driver.findElement(By.xpath("(//div[contains(@class,'mb-2')])[1]")).click();
		WebElement searchFrom = driver.findElement(By.xpath("//input[@class='search-form w-100']"));
		searchFrom.sendKeys("Del");
		Thread.sleep(2000);

		List<WebElement> options = driver.findElements(By.cssSelector("div[class='ms-1'] p"));

		// loop through the options
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Delhi, India")) {
				Thread.sleep(500); 
				//click the desirable option
				option.click();
				break;
			}

		}

		WebElement searchTo = driver.findElement(By.xpath("//input[@class='search-form w-100']"));
		searchTo.sendKeys("Dub");
		Thread.sleep(2000);

		List<WebElement> options2 = driver.findElements(By.xpath("//div[contains(@class,'airport-div')]"));
		for (WebElement option : options2) {
			if (option.getText().contains("Dubai, United Arab Emirates")) {
				Thread.sleep(500); 
				option.click();
				break;
			}
		}
		// departure
		String year = "2025";
		String month = "2";
		String date = "17";

		driver.findElement(By.cssSelector(".rdrYearPicker")).click();
		driver.findElement(By.xpath("//option[@value='" + year + "']")).click();
		// picking month
		driver.findElement(By.cssSelector(".rdrMonthPicker")).click();
		driver.findElement(By.xpath("//option[@value='" + month + "']")).click();
		// scrolling to make the date visible
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='" + date + "']")));
		Thread.sleep(500);
		// clicking on the date
		driver.findElement(By.xpath("//span[text()='" + date + "']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		
		
		// return date
		Thread.sleep(2000);
		String year2 = "2025";
		String month2 = "2";
		String date2 = "19";

		driver.findElement(By.cssSelector(".rdrYearPicker")).click();
		driver.findElement(By.xpath("//option[@value='" + year2 + "']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".rdrMonthPicker")).click();
		driver.findElement(By.xpath("//option[@value='" + month2 + "']")).click();
		Thread.sleep(1000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//span[text()='" + date2 + "']")));
		Thread.sleep(500);
		// clicking on the return date
		driver.findElement(By.xpath("//span[text()='" + date2 + "']")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		//travelers and booking class
		System.out.println(driver.findElement(By.cssSelector(".search-input-button.bg-active.mb-2")).getText());
		driver.findElement(By.cssSelector(".search-input-button.bg-active.mb-2")).click();

		int i=1;
		while(i<2)
		{
			driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
			i++;
		}
		driver.findElement(By.id("economy")).click();
		driver.findElement(By.cssSelector(".done-btn")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[id='submit_btn']")).click();

	}

}
