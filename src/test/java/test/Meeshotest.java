package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Meeshopage;

public class Meeshotest {
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	@BeforeMethod
	public void url()
	{
		driver.manage().window().maximize();
		driver.get("https://www.meesho.com/");
	}




@Test
public void test() throws IOException
{
Meeshopage me=new Meeshopage(driver);
me.search();
me.men();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
me.scrolldown();
me.assertion();

}}