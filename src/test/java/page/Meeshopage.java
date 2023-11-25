package page;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Meeshopage {
	
	WebDriver driver;
	By search=By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div/div[2]/div[1]/input");
	By men=By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[5]");
By jew=By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[6]/div/div[3]/a[5]/p");
By hair=By.xpath("//*[@id=\"__next\"]/div[4]/div[2]/div/div/div[2]/div[2]/div[24]/div[15]/div[2]/div/span[3]/a");


	public Meeshopage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void search()
	{
		driver.findElement(search).click();
		driver.findElement(search).sendKeys("saree");
	}
	public void men()
	{
		driver.findElement(men).click();
		driver.findElement(jew);
	}
	
	
	
	
public void scrolldown()
{
	//driver.navigate().refresh();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript ("window.scrollBy(0,document.body.scrollHeight)");//bottom of page
	driver.findElement(hair).click();
}
public void assertion()
	{
	String actual=driver.getTitle();
	System.out.println(actual);
	String exp="meesho.com";
	 Assert.assertEquals(actual,exp);
	 

		
		}}