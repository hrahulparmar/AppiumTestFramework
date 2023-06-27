package com.kwicon.objects.android;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.kwicon.utils.android.AndroidActions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ChooseInterestPage extends AndroidActions {

	AndroidDriver driver;

	public ChooseInterestPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@AndroidFindBy(accessibility = "go_back_btn")
	private WebElement interestBackArrow;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Get Started']")
	private WebElement getStarted;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Interests !']")
	private WebElement interstPageTitle;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Expertise !']")
	private WebElement expertisePageTitle;

	@AndroidFindBy(accessibility = "search_skills_input_box")
	private WebElement searchTopics;
	
	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"search_skills_input_box\"]/android.widget.TextView")
	private WebElement searchTopicsBoth;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Search topics']")
	private WebElement searchTopicsEdit;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'item_to_select')]/android.widget.TextView")
	private List<WebElement> topicsList;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[contains(@resource-id,'interest_')]/android.widget.TextView")
	private List<WebElement> academicsList;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"custome-btn\"]")
	private WebElement interestAddBtn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Academic Decathalon']")
	private WebElement suggestedTag;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Skip for now']")
	private WebElement skipForNow;

	@AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"checkbox_square\"]")
	private WebElement checkbox;

	@AndroidFindBy(accessibility = "selected_interest_0")
	private WebElement selectedInterestOne;

	@AndroidFindBy(accessibility = "selected_interest_1")
	private WebElement selectedInterestTwo;

	@AndroidFindBy(accessibility = "selected_experties_0")
	private WebElement selectedExpertiseOne;

	@AndroidFindBy(id = "toastAnimatedContainer")
	private WebElement toastErrMsg;

	public void addExpertise(String expertise) {
		searchTopics.click();
		searchTopicsEdit.sendKeys(expertise);
		for (WebElement topicElement : topicsList) {
			waitForElement(topicElement);
			String topicText = topicElement.getText();
			if (topicText.equalsIgnoreCase(expertise)) {
				System.out.println(topicText);
				topicElement.click();
				// longClickGesture(topicElement, 3000);
				longClickGesture(interestAddBtn, 3000);
				break;

			} else
				continue;
		}
		assertEquals(selectedExpertiseOne.isDisplayed(), true);
	}

	public void addExpertiseBoth(String expertise) throws InterruptedException {
		Thread.sleep(3000);
		waitForElement(searchTopicsBoth);
		longClickGesture(searchTopicsBoth, 5000);
		waitForElement(searchTopicsEdit);
		searchTopicsEdit.sendKeys(expertise);
		for (WebElement topicElement : topicsList) {
			waitForElement(topicElement);
			String topicText = topicElement.getText();
			if (topicText.equalsIgnoreCase(expertise)) {
				System.out.println(topicText);
				topicElement.click();
				// longClickGesture(topicElement, 3000);
				longClickGesture(interestAddBtn, 3000);
				break;

			} else
				continue;
		}
		assertEquals(selectedExpertiseOne.isDisplayed(), true);

	}

	public void addSearchTopics(String topic) {
		searchTopics.click();
		searchTopicsEdit.sendKeys(topic);
		for (WebElement topicElement : topicsList) {
			waitForElement(topicElement);
			String topicText = topicElement.getText();
			if (topicText.equalsIgnoreCase(topic)) {
				System.out.println(topicText);
				topicElement.click();
				longClickGesture(topicElement, 6000);
				longClickGesture(interestAddBtn, 5000);
				break;

			} else
				continue;
		}
		assertEquals(selectedInterestTwo.isDisplayed(), true);
	}

	public void addAcademicInterest(String academics) {
		for (WebElement academicsEle : academicsList) {
			waitForElement(academicsEle);
			String topicText = academicsEle.getText();
			if (topicText == null) {
				continue;
			} else if (topicText.equalsIgnoreCase(academics)) {
				clickGesture(academicsEle);
				break;
			}
		}
		assertEquals(selectedInterestOne.isDisplayed(), true);
	}

	public String interstPageTitle() {
		return interstPageTitle.getText();
	}

	public String expertisePageTitle() {
		return expertisePageTitle.getText();
	}

	public HomePage skipForNow() {
		skipForNow.click();
		return new HomePage(driver);
	}

	public void studentGetStarted() throws InterruptedException {

		waitForElement(getStarted);
		longClickGesture(getStarted, 6000);
	}

	public void expertiseGetStarted() throws InterruptedException {

		waitForElement(getStarted);
		longClickGesture(getStarted, 3000);
	}
	public void bothGetStarted() throws InterruptedException {

		waitForElement(getStarted);
		longClickGesture(getStarted, 5000);
	}

	public void bothStep2Next() throws InterruptedException {

		longClickGesture(interestAddBtn, 3000);
	}

}
