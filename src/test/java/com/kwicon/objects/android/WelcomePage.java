package com.kwicon.objects.android;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomePage extends AndroidActions {

	AndroidDriver driver;

	public WelcomePage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(accessibility = "go_back_btn")
	private WebElement welcomeBackArrow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Welcome!']")
	private WebElement pageTitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
	private WebElement firstName;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
	private WebElement lastName;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='What’s your school name?'] | /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
	private WebElement schoolName;

	@AndroidFindBy(accessibility = "select_grade")
	private WebElement gradePop;

	@AndroidFindBy(className = "android.widget.TextView")
	private List<WebElement> gradeList;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
	private WebElement linkedURL;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Upload CV']")
	private WebElement uploadCV;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Let people know a little bit about you.'] | /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[4]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
	private WebElement aboutMe;

	@AndroidFindBy(accessibility = "introduction_next_btn")
	private WebElement welcomeNextBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='What’s your field of work?'] | /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")
	private WebElement profession;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
	private WebElement proPic;

	@AndroidFindBy(accessibility = "upload_image_btn")
	private WebElement uploadPic;

	@AndroidFindBy(id = "com.google.android.documentsui:id/icon_thumb")
	private List<WebElement> selectImage;

	@AndroidFindBy(accessibility = "Crop")
	private WebElement cropImageTick;

	@AndroidFindBy(accessibility = "profile_photo_icon")
	private WebElement profilePhotoIcon;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup")
	private WebElement editProfilePhotoIcon;

	@AndroidFindBy(accessibility = "remove_image_btn")
	private WebElement removeProPhoto;

	@AndroidFindBy(accessibility = "take_photo_btn")
	private WebElement takeCamPhoto;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"select_grade\"]/android.view.ViewGroup/android.widget.TextView")
	private WebElement selectedGrade;

	@AndroidFindBy(accessibility = "9th grade")
	private WebElement nineGrade;
	@AndroidFindBy(accessibility = "10th grade")
	private WebElement tenGrade;
	@AndroidFindBy(accessibility = "11th grade")
	private WebElement elevenGrade;
	@AndroidFindBy(accessibility = "12th grade")
	private WebElement twelveGrade;
	@AndroidFindBy(accessibility = "Undergraduate")
	private WebElement undergraduate;
	@AndroidFindBy(accessibility = "Graduate")
	private WebElement graduate;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter valid first name']")
	private WebElement firstNameValidation;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter valid last name']")
	private WebElement lastNameValidation;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Please enter your school name']")
	private WebElement schoolNameValidation;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='please select grade']")
	private WebElement selectGradeValidation;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'valid LinkedIn URL')]")
	private WebElement linkedinURLValidation;
	
	public boolean firstNameValidation()
	{
		return firstNameValidation.isDisplayed();
	}
	public boolean lastNameValidation()
	{
		return lastNameValidation.isDisplayed();
	}
	public boolean schoolNameValidation()
	{
		return schoolNameValidation.isDisplayed();
	}
	public boolean selectGradeValidation()
	{
		return selectGradeValidation.isDisplayed();
	}
	public boolean linkedinURLValidation()
	{
		return linkedinURLValidation.isDisplayed();
	}
	
	public void scrollTop()
	{
		scrollAction("up");
	}
	
	public void scrollDown()
	{
		scrollToText("Next");
	}
	
	public void selectGrade(String grade) {
		gradePop.click();

		switch (grade) {
		case "nine":
			nineGrade.click();
			break;
		case "ten":
			tenGrade.click();
			break;
		case "eleven":
			elevenGrade.click();
			break;
		case "twelve":
			twelveGrade.click();
			break;
		case "undergraduate":
			undergraduate.click();
			break;
		case "graduate":
			graduate.click();
			break;
		}
		assertEquals(selectedGrade.isDisplayed(), true);

		/*
		 * for (WebElement gradeElement : gradeList) { String gradeText =
		 * gradeElement.getText(); if (gradeText == null) { continue; } else if
		 * (gradeText.equalsIgnoreCase(grade)) { longClickGesture(gradeElement); break;
		 * }
		 * 
		 * }
		 */

	}

	public String getPagetitle() {
		return pageTitle.getText();
	}

	public void setprofilePicture(int index) {
		proPic.click();
		waitForElement(uploadPic);
		uploadPic.click();

		selectImage.get(index).click();
		waitForElement(cropImageTick);
		cropImageTick.click();
		assertEquals(profilePhotoIcon.isDisplayed(), true);

	}

	public void fillMandatoryStudent(String firstName, String lastName, String schoolName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		this.schoolName.clear();
		this.schoolName.sendKeys(schoolName);
	}

	public void fillMandatoryAdvisor(String firstName, String lastName, String profession) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		this.lastName.clear();
		this.lastName.sendKeys(lastName);
		this.profession.clear();
		this.profession.sendKeys(profession);
		scrollToText("Next");
	}

	public void fillNonMandate(String linkedInURL, String aboutMe) {
		scrollToText("Next");
		this.linkedURL.clear();
		this.linkedURL.sendKeys(linkedInURL);
		this.aboutMe.clear();
		this.aboutMe.sendKeys(aboutMe);
	}

	public ChooseInterestPage clickNext() throws InterruptedException {
		scrollToText("Next");
		longClickGesture(welcomeNextBtn);
		return new ChooseInterestPage(driver);
	}
}
