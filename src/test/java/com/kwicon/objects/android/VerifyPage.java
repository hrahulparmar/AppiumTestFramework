package com.kwicon.objects.android;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class VerifyPage extends AndroidActions {

	AndroidDriver driver;

	public VerifyPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(accessibility = "go_back_btngo_back_btn")
	private WebElement verifyBackArrow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Verify']")
	private WebElement pageTitle;

	@AndroidFindBy(accessibility = "login_email_input")
	private WebElement emailEdit;

	@AndroidFindBy(accessibility = "login_email_input_cerified_icon")
	private WebElement greenTick;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"otp_input\"]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.EditText")
	private WebElement otpField;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Resend Code']")
	private WebElement resendCodeBtn;

	@AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"custome-btn\"])[2]")
	private WebElement verifyBtn;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup[2]/android.widget.TextView[2]")
	private WebElement timer;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OTP length must be 4 characters long']")
	private WebElement otpLengthErrorMsg;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Invalid code. Please check your spam or tap on resend.']")
	private WebElement invalidCodeErrorMsg;

	public void clickBack() {
		verifyBackArrow.click();
	}

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public WebElement getEditEmail() {
		return emailEdit;
	}

	public void enterCode(String code) {
		otpField.sendKeys(code);
	}

	public void clickResendCode() {
		resendCodeBtn.click();
	}

	public void clickVerify()  {
		verifyBtn.click();
	}

	public String invalidCodeMsg() {
		return invalidCodeErrorMsg.getText();
	}

	public String otpLengthMsg() {
		return otpLengthErrorMsg.getText();
	}

}
