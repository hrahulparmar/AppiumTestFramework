package com.kwicon.objects.android;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MyProfilePage extends AndroidActions {

	AndroidDriver driver;

	public MyProfilePage(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.widget.TextView")
	WebElement profileName;

	@AndroidFindBy(accessibility = "go_back_btn")
	WebElement backBtnMyProfile;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='My Profile']")
	WebElement titleMyProfilePage;
	
	public void gobackToHome()
	{
		backBtnMyProfile.click();
	}

	public String getMyProfileTitle() {
		return titleMyProfilePage.getText();
	}

	public String getProfileName() {
		return profileName.getText();
	}
	
	public boolean compareProfileName(String name)
	{
		return getProfileName().equalsIgnoreCase(name);
	}
}
