package com.kwicon.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.kwicon.base.BaseTest;
import com.kwicon.objects.android.ChooseInterestPage;
import com.kwicon.objects.android.HomePage;
import com.kwicon.objects.android.MainLoginPage;
import com.kwicon.objects.android.RolePage;
import com.kwicon.objects.android.TypeEmailPage;
import com.kwicon.objects.android.VerifyPage;
import com.kwicon.objects.android.WalkThroughPage;
import com.kwicon.objects.android.WelcomePage;
import com.kwicon.utils.json.JSONTestData;

public class BothOnBoardingTests extends BaseTest {

	JSONTestData jtd = new JSONTestData("onboarding");

	@Test(priority = 1)
	public void bothOnboarding() throws InterruptedException {

		String email = jtd.getData("bothData", "emailID");
		String otp = jtd.getData("bothData", "otp");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		RolePage rolePage = new RolePage(driver);
		rolePage.selectBothRole();

		WelcomePage welcomePage = rolePage.clickNextBtn();
		String firstName = jtd.getData("bothData", "firstName");
		String lastName = jtd.getData("bothData", "lastName");
		String schoolName = jtd.getData("bothData", "schoolName");
		String grade = jtd.getData("bothData", "grade");
		String linkedInURL = jtd.getData("bothData", "linkedInURL");
		String aboutMe = jtd.getData("bothData", "aboutMe");
		String interest = jtd.getData("bothData", "interest");
		String academics = jtd.getData("bothData", "academics");
		String expertise = jtd.getData("bothData", "expertise");
		welcomePage.setprofilePicture(2);
		welcomePage.fillMandatoryStudent(firstName, lastName, schoolName);
		welcomePage.selectGrade(grade);
		welcomePage.fillNonMandate(linkedInURL, aboutMe);
		welcomePage.clickNext();

		ChooseInterestPage chooseInterestPage = new ChooseInterestPage(driver);

		chooseInterestPage.addAcademicInterest(academics);
		chooseInterestPage.addSearchTopics(interest);
		chooseInterestPage.bothStep2Next();
		chooseInterestPage.addExpertiseBoth(expertise);
		chooseInterestPage.bothGetStarted();

		HomePage homePage = new HomePage(driver);
		assertEquals(true, homePage.logoDisplayed());
		homePage.logoutToLogin();

	}

}
