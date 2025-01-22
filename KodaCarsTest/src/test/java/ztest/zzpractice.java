package ztest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class zzpractice {

	static WebDriver driver;
	static Properties prop;
	
	public zzpractice() {
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



	public static void initialization() {
		// TODO Auto-generated method stub
		String browserName =prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("Firefox")){
			driver = new FirefoxDriver();
		} else if(browserName.equals("Edge")){
			driver = new EdgeDriver();
	     }
		// Define an explicit wait with a timeout of 10 seconds
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
			}

}
