package WebComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button {
	public static class Clickbttn{
		public static void go(WebDriver driver, String Strname, String Strid, String Strclass) {
			try {
				if(Strname!=null) {
					WebElement clickbttnname = driver.findElement(By.name(Strname));
					clickbttnname.click();
				}else if(Strid!=null) {
					WebElement clickbttnid= driver.findElement(By.id(Strid));
					clickbttnid.click();
				}else if(Strclass!=null) {
					WebElement clickbttnclass= driver.findElement(By.className(Strclass));
					clickbttnclass.click();
				}else
					System.out.println("You need to provide the way to find the Button");
			}
			catch(Exception e) {
				System.out.println("Element not found"+e);
			}
		}

	}
}
