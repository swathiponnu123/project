package page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Projectpage {
	
	
WebDriver driver;
	
	By tcommunity=By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a");
	By tusername=By.xpath("//*[@id=\"es-username\"]");
	By tpassword=By.xpath("//*[@id=\"es-password\"]");
	By tlogin=By.xpath("//*[@id=\"loginbox\"]/fieldset/div[3]/div[2]/button");
	By tcity=By.xpath("/html/body/footer/a[3]");
	By tradiobtn=By.xpath("//*[@id=\"geek-search-form-729\"]/div[4]/div[2]/label[1]/input");
	By dest=By.xpath("/html/body/footer/a[2]");
    By afri=By.xpath("//*[@id=\"t3-content\"]/div[2]/article/section/ul/li[1]/a");
		
    By privacy=By.xpath("//*[@id=\"t3-footer\"]/section/div/div/div/div/p/span[4]/a[4]");
    
    By deals=By.xpath("/html/body/footer/a[1]");
    
    By search=By.xpath("//*[@id=\"rs_searchbox_multi\"]/div/div[7]/button");

	public Projectpage(WebDriver driver)
	{
    this.driver=driver;

	}
	

	public void logindatadriven() throws IOException  
	{
	File f=new File("D:\\drive.xlsx");
	FileInputStream fi=new FileInputStream(f);
	XSSFWorkbook wb=new XSSFWorkbook(fi);
	XSSFSheet sh=wb.getSheet("sheet1");
	System.out.println(sh.getLastRowNum());
	driver.findElement(tcommunity).click();

	for(int i=1;i<=sh.getLastRowNum();i++)
	{

		String usname=sh.getRow(i).getCell(0).getStringCellValue();
		System.out.println("username----"+usname);
		String pword=sh.getRow(i).getCell(1).getStringCellValue();
		System.out.println("password----"+pword);
		
		
		driver.findElement(tusername).clear();
		driver.findElement(tusername).sendKeys(usname);
		driver.findElement(tpassword).clear();
		driver.findElement(tpassword).sendKeys(pword);
		driver.navigate().refresh();


		}}
	public void titleverification()
	{
		driver.findElement(tlogin).click();
		driver.navigate().back();
		driver.navigate().back();
	
		String act=driver.getTitle();
		String exp="travel";
		if(act.equals(exp))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
	}


	public void  contentverification()
	{
		driver.getCurrentUrl();
	String src=driver.getPageSource();//get source of last loaded web page
			if(src.contains("log in"))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}
				}
	
	
	public void select()
	{
		driver.findElement(tcity).click();
		boolean b=driver.findElement(tradiobtn).isSelected();
		if(b)
		{
			System.out.println("is selected");
		}
		else
		{
			System.out.println("not selected");
	
		}
	}
	
public void back() 
{
	driver.navigate().back();

 
}

public void asserts()
{
	String actual=driver.getCurrentUrl();
	System.out.println(actual);
	String exp="https://travel.com/";
	 Assert.assertEquals(actual,exp);
	 


	
}
public void doubleclick()
{
	driver.findElement(dest).click();
WebElement act=driver.findElement(afri);

Actions ac=new Actions(driver);

ac.doubleClick(act);
ac.perform();

}

public void scroll()
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	//js.executeScript("window.scrollBy(0,1000)", "");//using pixel
	
	//js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[6]/ul/li[2]/a")));//until element visible//privacy policy inspect
	
	js.executeScript ("window.scrollBy(0,document.body.scrollHeight)");//bottom of page
	driver.findElement(privacy).click();		
	driver.navigate().back();
	driver.navigate().back();
	driver.navigate().back();
}

public void datepick()
{
	driver.findElement(deals).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 driver.findElement(By.xpath("//*[@id=\"rs_searchbox_multi\"]/div/div[3]/div/i")).click();


	while(true)
	{
		
		WebElement month=driver.findElement(By.xpath("//*[@id=\"rs_searchbox_multi\"]/div/div[3]/div/div/div/div/span[1]"));
		String month1=month.getText();
		if(month1.equals("October 2023"))
		{
			System.out.println(month1);
			break;
		}
		else
		{
			driver.findElement(By.xpath("//*[@id=\"rs_searchbox_multi\"]/div/div[3]/div/div/div/div/span[2]")).click();
		}
	}

	List<WebElement> alldates = driver.findElements(By.xpath("//*[@id=\"rs_searchbox_multi\"]/div/div[3]/div/div/div/table/tbody/tr/td"));
	for(WebElement dateelement:alldates)
	{
		String date=dateelement.getText();
		if(date.equals("31"))
		{
			dateelement.click();
			break;
		}}
	
//driver.findElement(search).click();	
}
public void alert()
{
	driver.findElement(search).click();
	Alert a= driver.switchTo().alert();
	a.accept();
}
}








