package com.kwicon.objects.android;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends AndroidActions  {

	AndroidDriver driver;
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver= driver;
	}
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/com.horcrux.svg.SvgView")
	private WebElement homeLogo;
	
	@AndroidFindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
	private WebElement profileIcon;

	@AndroidFindBy(xpath="//android.widget.TextView[@text='Logout']")
	private WebElement logoutOption;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='My Profile']")
	private WebElement myProfileOption;
	
	public boolean logoDisplayed()
	{
		return homeLogo.isDisplayed();
	}
	
	public MyProfilePage openMyprofile()
	{
		waitForElement(profileIcon);
		longClickGesture(profileIcon);
		waitForElement(myProfileOption);
		myProfileOption.click();
		return new MyProfilePage(driver);
	}
	
	public MainLoginPage logoutToLogin()
	{
		waitForElement(profileIcon);
		longClickGesture(profileIcon);
		waitForElement(logoutOption);
		logoutOption.click();
		return new MainLoginPage(driver);
	}
}
