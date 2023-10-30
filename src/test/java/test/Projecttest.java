package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Projectpage;

public class Projecttest {
	
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
		driver.get("https://travel.com/");

	}
	@Test
	public void test() throws IOException
	{
		Projectpage pro=new Projectpage(driver);
		pro.logindatadriven();
		pro.titleverification();
		pro.contentverification();
	pro.select();
       pro.back();
     
        
       pro.asserts();
pro.doubleclick();
pro.scroll();
pro.datepick();
pro.alert();

    
	}
	}



