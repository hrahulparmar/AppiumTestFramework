package com.kwicon.tests;

import org.testng.Assert;
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

public class AdvisorOnBoardingTests extends BaseTest {

	JSONTestData jtd = new JSONTestData("onboarding");

	@Test(priority = 1)
	public void advisorOnboarding() throws InterruptedException {

		String email = jtd.getData("advisorData", "emailID");
		String otp = jtd.getData("advisorData", "otp");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();
		
		RolePage rolePage = new RolePage(driver);
		rolePage.selectAdvisorRole();

		WelcomePage welcomePage = rolePage.clickNextBtn();
		String firstName = jtd.getData("advisorData", "firstName");
		String lastName = jtd.getData("advisorData", "lastName");
		String profession = jtd.getData("advisorData", "profession");
		String linkedInURL = jtd.getData("advisorData", "linkedInURL");
		String aboutMe = jtd.getData("advisorData", "aboutMe");
		String expertise = jtd.getData("advisorData", "expertise");
		welcomePage.setprofilePicture(1);
		welcomePage.fillMandatoryAdvisor(firstName, lastName, profession);
		welcomePage.fillNonMandate(linkedInURL, aboutMe);
		welcomePage.clickNext();

		ChooseInterestPage chooseInterestPage = new ChooseInterestPage(driver);
		
		chooseInterestPage.addExpertise(expertise);

		chooseInterestPage.expertiseGetStarted();
	
		HomePage homePage = new HomePage(driver);
		Assert.assertEquals(homePage.logoDisplayed(), true);
		homePage.logoutToLogin();

	}

}
