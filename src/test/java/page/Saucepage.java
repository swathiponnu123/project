package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Saucepage {
	
	WebDriver driver;
	By uname=By.xpath("//*[@id=\"user-name\"]");
	By pass=By.xpath("//*[@id=\"password\"]");
	By login=By.xpath("//*[@id=\"login-button\"]");
	
	By cart1=By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
	By cart2=By.xpath("//*[@id=\"add-to-cart-sauce-labs-bike-light\"]");
	By cart3=By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]");
	By cart4=By.xpath("//*[@id=\"add-to-cart-sauce-labs-fleece-jacket\"]");
	By cart5=By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]");
	By cart6=By.xpath("//*[@id=\"add-to-cart-test.allthethings()-t-shirt-(red)\"]");
	
	By clickcart=By.xpath("//*[@id=\"shopping_cart_container\"]/a");
	By checkout=By.xpath("//button[@id='checkout']");
	
	By fnmae=By.xpath("//*[@id=\"first-name\"]");
	By lname=By.xpath("//*[@id=\"last-name\"]");
	By zip=By.xpath("//*[@id=\"postal-code\"]");
	By continuee=By.xpath("//*[@id=\"continue\"]");
	
	By ham=By.xpath("//*[@id=\"react-burger-menu-btn\"]");
	By logout=By.xpath("//*[@id=\"logout_sidebar_link\"]");
	
	
	public Saucepage(WebDriver driver)
	{
	this.driver=driver;
	}
	public void logindatadriven() throws IOException  
	{
		File f=new File("D:\\list1.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
			String usname=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("Username---"+usname);
			String passwd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Password---"+passwd);
			
			driver.findElement(uname).clear();
			driver.findElement(uname).sendKeys(usname);
			driver.findElement(pass).clear();
			driver.findElement(pass).sendKeys(passwd);
		}
	}
	public void loginbtn()
	{
		driver.findElement(login).click();
	}
	public void addcart()
	{
		driver.findElement(cart1).click();
		driver.findElement(cart2).click();
		driver.findElement(cart3).click();
		driver.findElement(cart4).click();
		driver.findElement(cart5).click();
		driver.findElement(cart6).click();
	}
	public void clickcheckout()
	{
		driver.findElement(clickcart).click();
		driver.findElement(checkout).click();
	}
	public void fiilcontinue(String fname1,String lname2,String zip2)
	{
		driver.findElement(fnmae).sendKeys(fname1);
		driver.findElement(lname).sendKeys(lname2);
		driver.findElement(zip).sendKeys(zip2);
		driver.findElement(continuee).click();
	}
	public void backlogut()
	{
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(ham).click();
		driver.findElement(logout).click();
	}
}


