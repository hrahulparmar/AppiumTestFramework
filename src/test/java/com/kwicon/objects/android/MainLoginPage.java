package com.kwicon.objects.android;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MainLoginPage extends AndroidActions {

	AndroidDriver driver;

	public MainLoginPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")
	private WebElement kwiconLogo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login / Register']")
	private WebElement pageTitle;

	@AndroidFindBy(accessibility = "login_email_input")
	private WebElement emailTextBox;
	
	@AndroidFindBy(accessibility = "go_back_btn")
	private WebElement backArrow;
	
	@AndroidFindBy(accessibility = "Rahul Parmar gbharkdekho1@gmail.com")
	private WebElement selectGmailAccount;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue with Google']")
	private WebElement googleLoginLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
	private WebElement policyLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms of Service']")
	private WebElement termsLink;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Privacy Policy at Kwicon']")
	private WebElement privacyPageTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Terms & Conditions for Kwicon']")
	private WebElement termsPageTitle;

	public boolean logoIsDisplayed() {
		return kwiconLogo.isDisplayed();
	}

	public TypeEmailPage clickEmail() {
		emailTextBox.click();
		return new TypeEmailPage(driver);
	}

	public void continueWithGoogle() {
		googleLoginLink.click();
		selectGmailAccount.click();
	}

	public boolean clickOnPrivacy() {
		policyLink.click();
		scrollToEndAction();
		return privacyPageTitle.isDisplayed();
	}
	public boolean clickOnTerms() {
		termsLink.click();
		scrollToEndAction();
		return termsPageTitle.isDisplayed();
	}

	public void BackButtonPrivacy()
	{
		backArrow.click();
	}
	public boolean getKwiconLogo() {
		return kwiconLogo.isDisplayed();
	}

	public boolean getPageTitle() {
		return pageTitle.isDisplayed();
	}

}
