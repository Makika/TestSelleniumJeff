package Waits;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class WaitExist {
	public static class Waitforexistance{
		public static Boolean go(WebDriver driver, String Strid) {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.elementToBeClickable(By.id(Strid)));
			return true;
		}
	}
}
