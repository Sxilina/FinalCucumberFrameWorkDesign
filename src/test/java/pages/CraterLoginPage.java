package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class CraterLoginPage {

	public CraterLoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy (css = "svg[class='block w-48 h-auto max-w-full mb-32 text-primary-500']")
	public WebElement loginPageTitle;
	
	@FindBy(xpath = "//div[contains(text(),'Email')]")
	public WebElement emailText;
	
	@FindBy(xpath = "//div[contains (text(),'Password')]")
	public WebElement passwordText;
	
	@FindBy(xpath = "//p[contains (text(),'Copyright @ Crater Invoice, Inc. 2023')]")
	public WebElement CopyRightText;
	
	@FindBy(xpath = "//h1[contains (text(),'Simple Invoicing ')]")
	public WebElement Heading1;
	
	@FindBy(xpath = "//p[contains (@class, 'hidden text-sm ')]")
	public WebElement Heading2;
	
	@FindBy(xpath = "//div[@name='email']/input")
	public WebElement useremail;
	

	@FindBy(xpath = "//div[@name='password']/input")
	public WebElement password;
	
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement loginButton;
	

	@FindBy(linkText = "Forgot Password?")
	public WebElement forgotPasswordLink;

	
	
	@FindBy (xpath = "//span[text()='Amount Due']")
	public WebElement amountDueText;

	@FindBy(xpath = "//p[contains(text(), 'These credentials do not match our records.')]")
	public WebElement invalidUserErrorMessage;

	@FindBy(xpath = "//span[text()='Field is required']")
	public WebElement fieldRequired;
	
	@FindBy(xpath = "//div[text() = 'Enter email ']")
	public WebElement enterEmailText;
	
	@FindBy(css = "button[type= submit]")
	public WebElement SendResetLink;
	
	@FindBy(xpath = "//a[text ()= 'Back to Login?']")
	public WebElement BacktoLogin;
	
	@FindBy(xpath = "//div[@name = 'email']")
	public WebElement enterEmailField;
	
	@FindBy(xpath = "//div/span[contains(text(), 'Incorrect')]")
	public WebElement IncorrectEmailMessage;
	
	@FindBy(xpath = "//p[contains(text(), 'Mail sent successfully')]")
	public WebElement SuccessMessage;
	
	
	
}
	

