package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class demo {
	
	public static WebDriver webDriver = null;
	
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		webDriver.navigate().to("http://dev-1.primedistribution.asia/");
		webDriver.manage().window().maximize();
		String title = webDriver.getTitle();
		
		if(title.equalsIgnoreCase("Prime Distribution")) {
			System.out.println("title matches");
		} else {
			System.out.println("[BUG]" +title);
		}
		
		WebElement userName = webDriver.findElement(By.id("__BVID__33"));
		userName.sendKeys("prime@production.com.vn");
		Thread.sleep(2000);
		
		WebElement password = webDriver.findElement(By.id("__BVID__35"));
		password.sendKeys("password1");
		Thread.sleep(2000);
		
		webDriver.findElement(By.className("btn-primary")).click();
		Thread.sleep(2000);
		
		String errorLogin = "";
		errorLogin = webDriver.findElement(By.className("notification-container-empty")).getText();
		if (errorLogin.equalsIgnoreCase("")) {
			System.out.println("success content");
		} else {
			System.out.println("a");
		}
		
		
//		Actions action = new Actions(webDriver);
//		String tagname = "";
//		tagname = webDriver.findElement(By.cssSelector("#searchDropdownBox")).getText();
//		System.out.println(tagname);
//		
//		//check option in select
//		Select dropdown = new Select(webDriver.findElement(By.id("searchDropdownBox")));
//		dropdown.selectByValue("search-alias=alexa-skills");
//		dropdown.selectByVisibleText("Alexa Skills");
//		
//		WebElement category = webDriver.findElement(By.cssSelector("#searchDropdownBox"));
//		action.moveToElement(category).perform();
//		Thread.sleep(2000);
//		
//		//click button
//		webDriver.findElement(By.linkText("Mobiles")).click();
//		Thread.sleep(2000);
//		
//		//input value
//		WebElement searchInput = webDriver.findElement(By.id("twotabsearchtextbox"));
//		searchInput.sendKeys("Apple");
//		Thread.sleep(2000);
//		
//		webDriver.findElement(By.id("nav-search-submit-button")).click();
//		Thread.sleep(2000);
//		
//		
	}

}
