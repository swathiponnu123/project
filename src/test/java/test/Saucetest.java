package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Saucepage;

public class Saucetest {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
	}
	@Test
	public void test1() throws IOException
	{
		Saucepage obj=new Saucepage(driver);
		obj.logindatadriven();
		obj.loginbtn();
		obj.addcart();
		obj.clickcheckout();
		obj.fiilcontinue("swathi", "shaji", "683577");
		obj.backlogut();
	}
}





