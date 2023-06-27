package com.kwicon.objects.android;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class RolePage extends AndroidActions {

	AndroidDriver driver;

	public RolePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Role !']")
	private WebElement pageTitle;

	@AndroidFindBy(accessibility =  "student_role_card")
	private WebElement studentRole;

	@AndroidFindBy(accessibility =  "advisor_role_card")
	private WebElement advisorRole;

	@AndroidFindBy(accessibility =  "both_role_card")
	private WebElement bothRole;

	@AndroidFindBy(className = "com.horcrux.svg.PathView")
	private WebElement greenCheck;

	@AndroidFindBy(accessibility = "choose_role_next_btn")
	private WebElement RoleNextBtn;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Please select role']")
	private WebElement roleToastError;

	public String getPageTitle() {
		return pageTitle.getText();
	}

	public void selectStudent() {
		studentRole.click();
	}

	public void selectAdvisorRole() {
		advisorRole.click();
	}
	public void selectBothRole() {
		bothRole.click();
	}

	public boolean checkGreen() {
		return greenCheck.isDisplayed();
	}

	public WelcomePage clickNextBtn() {
		clickGesture(RoleNextBtn);
		return new WelcomePage(driver);
	}
	public boolean toastMsgDisplayed()
	{
		return roleToastError.isDisplayed();
	}

}