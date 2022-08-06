package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Download and set the path
		WebDriverManager.chromedriver().setup();

		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		//Maximize the window
		driver.manage().window().maximize();

		//To enter the User Name
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		//To enter the Password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//To click on Login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//To click on CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();

		//To click on Contacts tab
		driver.findElement(By.linkText("Contacts")).click();

		//To click on Merge Contacts tab
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		//To click on widget of From Contact field
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		
		//To get the list of open windows
		Set<String> setWindow1 = driver.getWindowHandles();
		//To convert to list
		List<String> listWindow1 = new ArrayList<String>(setWindow1);

		String win1 = listWindow1.get(1);
		String win2 = listWindow1.get(0);
		//To switch control to new window 
		driver.switchTo().window(win1);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//To click on first resulting contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")).click();

		//To switch control to parent window 
		driver.switchTo().window(win2);

		//To click on widget of To Contact field
		driver.findElement(By.xpath("(//span[text()='To Contact']/following::img)[1]")).click();
		
		//To get the list of open windows
		Set<String> setWindow2  = driver.getWindowHandles();
		//To convert to list
		List<String> listWindow2  = new ArrayList<String>(setWindow2);;

		String win3 = listWindow2.get(1);
		String win4 = listWindow2.get(0);
		//To switch control to new window
		driver.switchTo().window(win3);
		
		//To click on second resulting contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]")).click(); 

		//To switch control to parent window
		driver.switchTo().window(win4);

		//To click on Merge button
		driver.findElement(By.xpath("//a[text()='Merge']")).click();

		//To switch and accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

		//To verify the title of the page
		String verifyTitle = driver.getTitle();
		System.out.println("Page Title is: " + verifyTitle);
	}
}
