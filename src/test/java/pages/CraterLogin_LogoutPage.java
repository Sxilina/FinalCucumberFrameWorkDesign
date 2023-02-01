package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Driver;

public class CraterLogin_LogoutPage {
   public CraterLogin_LogoutPage (){
   	 PageFactory.initElements(Driver.getDriver(), getClass());
   }

@FindBy (css="svg[viewBox='0 0 225 50']")
public WebElement pageTitle;

@FindBy (xpath="//div[@name='email']/input")
public WebElement username;

@FindBy (xpath="//div[@name=‘password’]/input")
public WebElement password;

@FindBy (xpath="//div[@class=‘Forgot Password?’]")
public WebElement forgotButton;

@FindBy (xpath="//button[contains(@class,‘Login’]")
public WebElement LoginButton;

@FindBy (xpath="//p[contains(text(),‘Copyright @’)]")
 public WebElement CopyRightText;

@FindBy (xpath="//h1[contains(text(),‘Simple Invoicing for’)]")
public WebElement Header1;

@FindBy (xpath="//p[contains(text(),‘record payments &’)]")
public WebElement Header2;

@FindBy (xpath="//p[contains(text(),‘Error’)]")
public WebElement ErrorMessage;

//@FindBy (xpath="")
//@FindBy (xpath="//p[contains(text(),‘These credentials do not’)]")
//public WebElement SubErrorMessage;
//
@FindBy(xpath ="//span[text()=‘Field is required’]")
public WebElement fieldRequired;


@FindBy(xpath ="//a[contains(text(),‘Items’]")
public WebElement DashBoardPage;


@FindBy (xpath="//button[contains(@id,‘headlessui-menu-button-63’]")
public WebElement LogoutIcon;


@FindBy (xpath="//a[contains(@href,‘Logout’]")
public WebElement LogoutButton;

@FindBy (xpath="//a[contains(@href,‘Settings’]")
public WebElement SettingsButton;








}