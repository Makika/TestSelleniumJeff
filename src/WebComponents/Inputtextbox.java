package WebComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Inputtextbox {
	public static class Entertext{
		public static void go(WebDriver driver, String Strtext, String Strname, String Strid) {
			try {
				if(Strname!=null) {
					WebElement inputtextname = driver.findElement(By.name(Strname));
					inputtextname.sendKeys(Strtext);
				}else if(Strid!=null) {
					WebElement inputtextid = driver.findElement(By.id(Strid));
					inputtextid.sendKeys(Strtext);
				}else
					System.out.println("You need to provide the way to find the web element");
			}
			catch(Exception e) {
				System.out.println("Element not found"+e);
			}
		}
		
	}
	
}
