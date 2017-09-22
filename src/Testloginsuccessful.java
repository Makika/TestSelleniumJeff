import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import Waits.WaitExist;
import WebComponents.Button;
import WebComponents.Inputtextbox;

public class Testloginsuccessful {
        
	public static WebDriver driver;
    public static String baseURL = "https://www.mydoterra.com/";
    
	public static void main(String[] args) throws NoSuchElementException, IOException {
		
		try{
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.mydoterra.com/");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit waits
        
        Inputtextbox.Entertext.go(driver, "4379306", "Username", null);
		
        //WebElement loginfieldbox = driver.findElement(By.name("Username"));
        //loginfieldbox.sendKeys("4379306");
        
        Inputtextbox.Entertext.go(driver, "Marthagodinez1", "password", null);
        //WebElement loginfieldpss = driver.findElement(By.name("password"));
        //loginfieldpss.sendKeys("Marthagodinez1");
        
        Button.Clickbttn.go(driver, null, null, "doterrasubmit");
        //WebElement loginbttnsubmit = driver.findElement(By.className("doterrasubmit")); 
        //loginbttnsubmit.click();
        
        //waitforexistance id:search_text_front_page
        if(WaitExist.Waitforexistance.go(driver, "search_text_front_page"))
        	System.out.println("You successfully login to doterra");
        else
        	System.out.println("You was not able to login successfully to doterra web page +"
        			+ "please check network connection or user and password");
        //Boolean belementfound = WaitExist.Waitforexistance.go(driver, "search_text_front_page");
        //System.out.println(belementfound);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
        
        driver.close();
        }catch (NoSuchElementException e) {
			System.out.println("Exception: " + e);
			System.out.println("*****************************");
		}
        
    }        
}