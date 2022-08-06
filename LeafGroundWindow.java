package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindow 
{
	public static void main(String[] args) 
	{
		//Download and set the path
		WebDriverManager.chromedriver().setup();

		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");

		//Maximize the window
		driver.manage().window().maximize();

		//To click button to open home page in New Window
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();

		//To get the set of window handles		
		Set<String> winSet = driver.getWindowHandles();
		//To convert to list
		List<String> winList = new ArrayList<String>(winSet);

		//To get the count of open windows
		System.out.println("Total number of open windows: " + winSet.size());

		//To click on Do Not close me button.
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();

		winSet = driver.getWindowHandles();
		winList = new ArrayList<String>(winSet);

		//To close all windows except main window
		for (int i =1; i<winList.size(); i++) 
		{
			driver.switchTo().window(winList.get(i));
			driver.close();
		}

		//To switch control to parent window
		driver.switchTo().window(winList.get(0));

		//Thread.sleep(2000);
		
		//To wait for 2 new windows to be opened
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println("Wait set for 2 new windows to open");
	}
}
