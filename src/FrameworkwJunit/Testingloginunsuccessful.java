package FrameworkwJunit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class Testingloginunsuccessful {
	private WebDriver driver;
	private String baseURL;
	
	@Before
	public void setuppage() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
	    driver = new ChromeDriver();
	    baseURL = "https://www.mydoterra.com/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown() throws Exception{
		driver.close();
		driver.quit();
	}
	
	@Test
	public void wrongpassnegativetest() throws Exception{
		driver.get(baseURL);
		WebElement loginfieldbox = driver.findElement(By.name("Username"));
        loginfieldbox.sendKeys("4379306");
        WebElement loginfieldpss = driver.findElement(By.name("password"));
        loginfieldpss.sendKeys("wrongpassword");
        WebElement loginbttnsubmit = driver.findElement(By.className("doterrasubmit")); 
        loginbttnsubmit.click();
        
        WebElement invalidlogin = driver.findElement(By.xpath(("//span [@class = 'error']")));
        if(invalidlogin.isDisplayed())
        	System.out.println("You entered a wrong user or password");
	}
	
	@Test
	public void forgetthepsstest() throws Exception{
		driver.get(baseURL);
		WebElement loginfieldbox = driver.findElement(By.name("Username"));
        loginfieldbox.sendKeys("4379306");
      
        //Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        System.out.println(winHandleBefore);
        WebElement forgetpassword = driver.findElement(By.linkText("Click Here"));
        forgetpassword.click();
        
      //Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);}
     
        WebElement forgotwin = driver.findElement(By.xpath("//span [@class = 'normaltext']"));
                  
        if (forgotwin.isEnabled()){
        	System.out.println("You are in a second opened window");
        }
        else{
        System.out.println("Second Window not opened"); 
        }
        // Perform the actions on new window
        //Close the new window, if that window no more required
        driver.close();
        //Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);
      
	}
}
