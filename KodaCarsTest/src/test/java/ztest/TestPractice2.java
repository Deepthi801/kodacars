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


public class TestPractice2 {
	
	public static WebDriver driver;
	public static Properties prop;
	public static JavascriptExecutor js;
	public static WebDriverWait wait;
	
	

	
	public TestPractice2() {
		try {
			prop=new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\vinay\\git\\repository\\KodaCarsTest\\src\\main\\java\\com\\KodaCars\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
			
		}
	}
	
    @Test(priority=1)	
	public static void initialization() throws InterruptedException {
		
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
		 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//addreservation
		driver.findElement(By.xpath("//label[@class='clr cursor']/i")).click();
		//click no reservation number
		driver.findElement(By.xpath("//div[@class='p-3 m-auto']/div[2]/div[1]")).click();
		  
		//Customer details
		// Wait for the page to load and the dropdown to be clickable
		WebElement mobilecode= driver.findElement(By.xpath("//ng-select[@formcontrolname='mobileCode']/div/div/div[3]/input"));
		mobilecode.click();
		driver.findElement(By.xpath("//ng-select[@formcontrolname='mobileCode']/div/span[1]")).click();
		driver.findElement(By.xpath("//ng-select[@formcontrolname='mobileCode']/ng-dropdown-panel/div/div[2]/div[1]")).click();
		//input[@formcontrolname='firstName']
		
		
         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname='location']/div/div/div[3]/input")));
        dropdown.click();

        // Wait for the dropdown options to appear
        WebElement dropdownPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-option ng-option-marked ng-star-inserted']")));
        // Find the desired option (e.g., "Damco, Noida") and click it
        WebElement desiredOption = dropdownPanel.findElement(By.xpath("//*[@formcontrolname='location']//ng-dropdown-panel"));
        desiredOption.click();

        
        //select source
        //source (2)
        // Wait for the dropdown options to appear
        
        //select source "AirportParkingReservations";
        WebElement dropdown_source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@formcontrolname='source']/div/div/div[2]/input")));
        dropdown_source.click();
     //   WebElement dropdown_list = dropdown_source.findElement(By.xpath("//ng-select[@formcontrolname='source']/ng-dropdown-panel/div"));
        WebElement dropdown_list = dropdown_source.findElement(By.xpath("//ng-select[@formcontrolname='source']/ng-dropdown-panel/div/div/div[5]"));
        dropdown_list.click();
        driver.findElement(By.xpath("//input[@formcontrolname='startDate']")).
        
        sendKeys("02/15/2025");
         driver.findElement(By.xpath("//input[@formcontrolname=\"startTime\"]")).sendKeys("9:00 AM");
         driver.findElement(By.xpath("//input[@formcontrolname=\"endDate\"]")).sendKeys("03/12/2025");
        driver.findElement(By.xpath("//input[@formcontrolname=\"endTime\"]")).sendKeys("6:00 PM");

        //vehicle details

        
        WebElement Vehicledetails=driver.findElement(By.xpath("//button[contains(text(),'Add Vehicle')]"));
        Vehicledetails.click();
        //select car color
        
        Thread.sleep(2000);
        WebElement color =driver.findElement(By.xpath("//ng-select[@formcontrolname='carColor']"));
        color.click();
       //car color
        String colour = prop.getProperty("grey");

        driver.findElement(By.xpath("//ng-dropdown-panel/div/div/div["+ colour + "]")).click();
      // select car make
         String carmake= prop.getProperty("Toyota");
         WebElement make =driver.findElement(By.xpath("//ng-select[@formcontrolname='make']/div/div/div[3]/input"));
         make.click();
         driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div[" + carmake +"]")).click();
         
         // car model
         driver.findElement(By.xpath("//ng-select[@formcontrolname='model']/div/div/div[3]/input")).click();
         String carModelIndex = (prop.getProperty("camry"));
         driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div[" + carModelIndex + "]")).click();
         // car licence
         driver.findElement(By.xpath("//input[@formcontrolname='licenseNo']")).sendKeys("Kjl 00987");
         driver.findElement(By.xpath("//ng-select[@formcontrolname='state']")).click();
         //car licence state
         driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div[5]")).click();
         driver.findElement(By.xpath("//input[@formcontrolname='ticket']")).sendKeys("87756780 ");
         driver.findElement(By.xpath("//input[@formcontrolname='tagId']")).sendKeys("Tg-0987");
         driver.findElement(By.xpath("//textarea[@formcontrolname='comment']")).sendKeys("This is comment section");
         js = (JavascriptExecutor) driver;
         js.executeScript("window.scrollBy(0,3500)");
         
             	    String carSize = prop.getProperty("carsize");
        	    if (carSize == null || carSize.isEmpty()) {
        	        System.out.println("Car is not oversize");
        	    } else {
        	        // Perform actions if car is oversize
        	        try {
        	            driver.findElement(By.xpath("//p-checkbox[@formcontrolname='isOverSized']")).click();  
        	            driver.findElement(By.xpath("//ng-select[@formcontrolname='vehicleOversizeCategoryId']")).click();
        	            driver.findElement(By.xpath("//ng-select[@formcontrolname='vehicleOversizeCategoryId']/ng-dropdown-panel/div/div[2]/div[2]")).click();
        	        } catch (Exception e) {
        	            System.err.println("Error performing Selenium actions: " + e.getMessage());
        	        }
        	
        	    }
        	    driver.findElement(By.xpath("//button[contains(text(),  'Create Reservation')]")).click();
    }

   		
}



