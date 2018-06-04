package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage
{
	public WebDriver driver;
	
	@FindBy(name="password")
	public WebElement pwd;
	
	@FindBy(xpath="//*[text()='Enter a password']")
	public WebElement blankpwderr;
	
	@FindBy(xpath="//*[contains(text(),'wrong password']")
	public WebElement invalidpwderr;
	
	@FindBy(xpath="//*[text(),'Next']")
	public WebElement pwdnext;

	
	
	public Loginpage(WebDriver x)
	{
		this.driver=x;
		PageFactory.initElements(driver, this);
	}
	
	public void fillpwd(String x)
	{
		pwd.sendKeys(x);
	}
	
	public void clickpwdnext()
	{
		pwdnext.click();
		
	}
	
	public class MailboxPage
	{
		public WebDriver driver;
		
		@FindBy(xpath="//*[text()='COMPOSE']")
		public WebElement comp;
		
		public MailboxPage(WebDriver x)
		{
			this.driver=x;
			PageFactory.initElements(driver, this);
		}
	}
	
	
}
