package com.kwicon.objects.android;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TypeEmailPage extends AndroidActions {

	AndroidDriver driver;

	public TypeEmailPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
	private WebElement pageTitle;

	@AndroidFindBy(accessibility = "go_back_btn")
	private WebElement emailbackArrow;

	@AndroidFindBy(accessibility = "login_email_input")
	private WebElement emailTextField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue']")
	private WebElement continueBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid mail. Please try again.']")
	private WebElement invalidEmailErrorMsg;

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void setEmail(String email) {
		emailTextField.sendKeys(email);
	}

	public VerifyPage clickContinue() {
		continueBtn.click();
		return new VerifyPage(driver);
	}

	public String invalidEmailToastMsg() {
		return invalidEmailErrorMsg.getText();
	}

}
