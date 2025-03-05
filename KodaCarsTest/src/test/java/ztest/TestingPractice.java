package ztest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestingPractice {
	
	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor js;
	
	

	
	public TestingPractice() {
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\vinay\\eclipse-workspace\\KodaCarsTest\\src\\main\\java\\com\\KodaCars\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
    @Test	
	public static void initialization() {
		
		String browserName =prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")){
			driver = new FirefoxDriver();
		} else if(browserName.equals("Edge")){
			driver = new EdgeDriver();
	     }
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//login
		driver.findElement(By.xpath("//input[@formcontrolname='userName']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//addreservation
		driver.findElement(By.xpath("//label[@class='clr cursor']/i")).click();
		//click no reservation number
		driver.findElement(By.xpath("//div[@class='p-3 m-auto']/div[2]/div[1]")).click();
		  
		//Location selection
		// Wait for the page to load and the dropdown to be clickable
		
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname='location']/div/div/div[3]/input")));
        dropdown.click();
        WebElement dropdownPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-option ng-option-marked ng-star-inserted']")));
        WebElement desiredOption = dropdownPanel.findElement(By.xpath("//*[@formcontrolname='location']//ng-dropdown-panel"));
        desiredOption.click();

        
        //select source "AirportParkingReservations";
        WebElement dropdown_source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@formcontrolname='source']/div/div/div[2]/input")));
        dropdown_source.click();
        WebElement dropdown_list = dropdown_source.findElement(By.xpath("//ng-select[@formcontrolname='source']/ng-dropdown-panel/div"));
        dropdown_list.click();

}
   
        }


    


