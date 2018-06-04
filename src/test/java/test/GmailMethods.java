package test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Homepage;
import pages.Loginpage;
import pages.Loginpage.MailboxPage;

public class GmailMethods
{
	public WebDriver driver;
	public Homepage hp;
	public Loginpage lp;
	public MailboxPage mp;
	public Scenario s;
	public Properties pro;
	
@Before
public void method1(Scenario x) throws Exception
{
	this.s=x;
	pro=new Properties();
	FileInputStream fip=new FileInputStream("C:\\Users\\tusshar\\eclipse-workspace\\gmailbdd\\src\\test\\resources\\golbalvalue.properties");
	pro.load(fip);
	
	System.setProperty("webdriver.gecko.driver",pro.getProperty("geckodriver"));
	driver=new FirefoxDriver();
	
	hp=new Homepage(driver);
	lp=new Loginpage(driver);
	
	
	
}
@Given("^launch gmail site$")
public void method2() throws Exception
{
	driver.get(pro.getProperty("url"));
	Thread.sleep(5000);
}
	
@Then("^title is \"(.*)\" value$")
public void method3(String x)
{
	String t=driver.getTitle();
	if(t.equals(x))
	{
		s.write("Title test was Passed");
	}
	else
	{
		byte[] src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(src, "Title test Failed!!!!!!!!!!!!!!!");
		driver.close();
	}
	
}

@And("^close site$")
public void method4()
{
	driver.close();
}
@When("^enter userid with \"(.*)\" value$")
public void method5(String u) throws Exception
{
	hp.filluid(u);
	Thread.sleep(5000);
}

@And("^click next button$") 
public void method6() throws Exception
{
	hp.clickuidnext();
	Thread.sleep(5000);
}
@Then("^validate userid field with \"(.*)\" criteria$") 
public void method7(String c)
{
	if(c.equalsIgnoreCase("valid")&& lp.pwd.isDisplayed())
	{
		s.write("valid uid test was passed");
	}
	else if(c.equalsIgnoreCase("blank")&& hp.blankuiderr.isDisplayed())
	{
		s.write("Blank uid test was passed");
	}
	else if(c.equalsIgnoreCase("invalid")&& hp.invaliduiderr.isDisplayed())
	{
		s.write("invalid uid test was passed");
	}
	else
	{
		byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(b, "uid test failed");
		driver.close();
	}
}

@And("^enter password with \"(.*)\" value$")
public void method8(String p) throws Exception
{
	lp.fillpwd(p);
	Thread.sleep(5000);
}

@And("^click password next button$")
public void method9() throws Exception
{
	lp.clickpwdnext();
	Thread.sleep(5000);
}
@Then("^validate password with \"(.*)\" criteria$")
public void method10(String c)
{
	if(c.equalsIgnoreCase("valid")&& mp.comp.isDisplayed())
	{
		s.write("valid pwd test passed");
	}
	else if(c.equalsIgnoreCase("blank")&& lp.blankpwderr.isDisplayed())
	{
		s.write("blank pwd test passed");
	}
	else if (c.equalsIgnoreCase("invalid")&& lp.invalidpwderr.isDisplayed())
	{
		s.write("invalid pwd test passed");
	}
	else
	{
		byte[] b=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		s.embed(b, "pwd test failed");
		driver.close();
	}
}
}
