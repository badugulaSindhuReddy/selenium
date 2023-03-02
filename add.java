package flipkart;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class add {
	public static void main(String[] args)throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\reba3001\\Downloads\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	WebElement closeButton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
	closeButton.click();
	WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
	searchBox.sendKeys("iphone");
	searchBox.submit();
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_2kHMtA']")));
	firstResult.click();
	String parentWindow = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();
	for (String window : windows) {
	    if (!window.equals(parentWindow)) {
	        driver.switchTo().window(window);
	    }
	}
	WebElement ram=driver.findElement(By.xpath("//*[@id=\"swatch-0-storage\"]/a"));
	ram.click();
	WebElement colour=driver.findElement(By.xpath(("//*[@id=\"swatch-0-color\"]/a")));
	colour.click();
	WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(text(), 'ADD TO CART')]"));
	addToCartButton.click();
	}
}