package week4.day1;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Salesforce
{
	public static void main(String[] args) 
	{
		//Download and set the path
		WebDriverManager.chromedriver().setup();

		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("https://login.salesforce.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Maximize the window
		driver.manage().window().maximize();

		//To enter the User Name
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");

		//To enter the Password
		driver.findElement(By.id("password")).sendKeys("Password$123");

		//To click on Login button
		driver.findElement(By.id("Login")).click();

		//To click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();

		//To switch to the next window using Windowhandles
		Set<String> winSet = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(winSet);
		driver.switchTo().window(winList.get(1));

		//To click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();

		//To get the title
		System.out.println("Title is:  " + driver.getTitle());

		//To get back to the parent window
		driver.switchTo().window(winList.get(0));

		//To close the browser
		driver.close();	
	}
}
