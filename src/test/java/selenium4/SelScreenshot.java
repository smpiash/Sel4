package selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelScreenshot {



	@Test
	public void screenshotTest() throws IOException {
	
	
	//public static void main(String[] args)throws IOException {
		
//		//Firefox 
//		WebDriverManager.firefoxdriver().setup();
//		WebDriver driver = new FirefoxDriver();
		
		//Chrome
		//System.setProperty("webdriver.chrome.driver", "/Users/syedhussain/Downloads/chromedriver");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));

		File file = logo.getScreenshotAs(OutputType.FILE);

		File destinationFile = new File("logo.png");
		FileUtils.copyFile(file, destinationFile);
		
		System.out.println("Test success");

		driver.quit();

	}



}
