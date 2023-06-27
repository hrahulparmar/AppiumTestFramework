package com.kwicon.objects.android;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WalkThroughPage extends AndroidActions {

	AndroidDriver driver;

	public WalkThroughPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(accessibility = "intro_skip_btn")
	private WebElement btnSkip;

	@AndroidFindBy(accessibility = "intro_next_arrow")
	private WebElement btnArrow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Next']")
	private WebElement walkthroughNextbtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Explore Careers !']")
	private WebElement slideOneTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Pick a topic that interests you and learn more about the skills required for a career.']")
	private WebElement slideOneText;

	@AndroidFindBy(className = "com.horcrux.svg.PathView")
	private WebElement slideOneImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Chat with Experts !']")
	private WebElement slideTwoTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Reach out to mentors & professionals to gain actionable advice on your area of interest.']")
	private WebElement slideTwoText;

	@AndroidFindBy(className = "com.horcrux.svg.PathView")
	private WebElement slideTwoImage;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Guide your Peers !']")
	private WebElement slideThreeTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Contribute to the community by sharing experiences of your learning path. Grow while you teach.']")
	private WebElement slideThreeText;

	@AndroidFindBy(className = "com.horcrux.svg.PathView")
	private WebElement slideThreeImage;

	public void clickNextOnce() {
		btnArrow.click();
	}

	public MainLoginPage nextToLogin() throws InterruptedException {
		btnArrow.click();
		Thread.sleep(2000);
		btnArrow.click();
		Thread.sleep(2000);
		walkthroughNextbtn.click();
		Thread.sleep(2000);

		return new MainLoginPage(driver);
	}

	public MainLoginPage skipToLogin() {

		btnSkip.click();
		return new MainLoginPage(driver);

	}

	public Boolean validateSlideOne() {
		boolean flag = false;
		if ((slideOneTitle.getText()).equalsIgnoreCase("Explore Careers !") && slideOneImage.isDisplayed()) {

			flag = (slideOneText.getText()).equalsIgnoreCase(
					"Pick a topic that interests you and learn more about the skills required for a career.");
			return flag;
		} else
			return flag;
	}

	public Boolean validateSlideTwo() {
		boolean flag = false;
		if ((slideTwoTitle.getText()).equalsIgnoreCase("Chat with Experts !") && slideTwoImage.isDisplayed()) {
			flag = (slideTwoText.getText()).equalsIgnoreCase(
					"Reach out to mentors & professionals to gain actionable advice on your area of interest.");
			return flag;
		} else
			return flag;
	}

	public Boolean validateSlideThree() {
		boolean flag = false;
		if ((slideThreeTitle.getText()).equalsIgnoreCase("Guide your Peers !") && slideThreeImage.isDisplayed()) {

			flag = (slideThreeText.getText()).equalsIgnoreCase(
					"Contribute to the community by sharing experiences of your learning path. Grow while you teach.");
			return flag;
		} else
			return flag;
	}

}
