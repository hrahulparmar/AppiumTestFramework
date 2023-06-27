package com.kwicon.tests;

import static org.testng.Assert.assertEquals;

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

public class StudentOnBoardingTests extends BaseTest {

	JSONTestData jtd = new JSONTestData("onboarding");

	@Test(priority = 2)
	public void studentOnboarding() throws InterruptedException {

		String email = jtd.getData("studentData", "emailID");
		String otp = jtd.getData("studentData", "otp");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		RolePage rolePage = new RolePage(driver);
		rolePage.selectStudent();

		WelcomePage welcomePage = rolePage.clickNextBtn();
		String firstName = jtd.getData("studentData", "firstName");
		String lastName = jtd.getData("studentData", "lastName");
		String schoolName = jtd.getData("studentData", "schoolName");
		String linkedInURL = jtd.getData("studentData", "linkedInURL");
		String aboutMe = jtd.getData("studentData", "aboutMe");
		String interest = jtd.getData("studentData", "interest");
		String grade = jtd.getData("studentData", "grade");
		String academics = jtd.getData("studentData", "academics");

		welcomePage.setprofilePicture(0);
		welcomePage.fillMandatoryStudent(firstName, lastName, schoolName);
		welcomePage.selectGrade(grade);
		welcomePage.fillNonMandate(linkedInURL, aboutMe);
		welcomePage.clickNext();

		ChooseInterestPage chooseInterestPage = new ChooseInterestPage(driver);
		chooseInterestPage.addAcademicInterest(academics);
		chooseInterestPage.addSearchTopics(interest);
		chooseInterestPage.studentGetStarted();

		HomePage homePage = new HomePage(driver);
		assertEquals(true, homePage.logoDisplayed());
		homePage.logoutToLogin();

	}

	@Test(priority = 1)
	public void studentOnBoardingNegative() throws InterruptedException
	{
		String email = jtd.getData("negative", "emailID");
		String otp = jtd.getData("negative", "otp");
		String url = jtd.getData("negative", "linkedInURL");
		String aboutMe = jtd.getData("negative", "aboutMe");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		RolePage rolePage = new RolePage(driver);
		rolePage.selectStudent();
		rolePage.clickNextBtn();
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.fillNonMandate(url, aboutMe);
		welcomePage.clickNext();
		WelcomePage refreshPage = new WelcomePage(driver);
		refreshPage.scrollTop();
		
		//Assert.assertEquals(refreshPage.firstNameValidation(), true);
		Assert.assertEquals(refreshPage.lastNameValidation(), true);
		Assert.assertEquals(refreshPage.schoolNameValidation(), true);
		refreshPage.scrollDown();
		
		Assert.assertEquals(refreshPage.selectGradeValidation(), true);
		Assert.assertEquals(refreshPage.linkedinURLValidation(), true);
		
	}
	
	
	@Test(enabled = false)
	public void chooseInterestMethod() throws InterruptedException {
		String email = jtd.getData("studentData", "emailID");
		String otp = jtd.getData("studentData", "otp");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		RolePage rolePage = new RolePage(driver);
		rolePage.selectStudent();

		WelcomePage welcomePage = rolePage.clickNextBtn();

		String firstName = jtd.getData("studentData", "firstName");
		String lastName = jtd.getData("studentData", "lastName");
		String schoolName = jtd.getData("studentData", "schoolName");
		String linkedInURL = jtd.getData("studentData", "linkedInURL");
		String grade = jtd.getData("studentData", "grade");
		String aboutMe = jtd.getData("studentData", "aboutMe");
		String interest = jtd.getData("studentData", "interest");
		String academics = jtd.getData("studentData", "academics");

		// welcomePage.setprofilePicture(0);
		 welcomePage.fillMandatoryStudent(firstName, lastName, schoolName);
		 welcomePage.selectGrade(grade);
		// welcomePage.fillNonMandate(linkedInURL, aboutMe);
		welcomePage.clickNext();
		ChooseInterestPage chooseInterestPage = new ChooseInterestPage(driver);
		// chooseInterestPage.addAcademicInterest(academics);
		chooseInterestPage.addSearchTopics(interest);
		Thread.sleep(5000);

	}

	@Test(enabled = false)
	public void gradeSelectMethod() throws InterruptedException {
		String email = jtd.getData("studentData", "emailID");
		String otp = jtd.getData("studentData", "otp");
		String grade = jtd.getData("studentData", "grade");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		RolePage rolePage = new RolePage(driver);
		rolePage.selectStudent();

		WelcomePage welcomePage = rolePage.clickNextBtn();

		welcomePage.selectGrade(grade);
		Thread.sleep(10000);
	}

	@Test(enabled = false)
	public void uploadProfileImage() throws InterruptedException {
		String email = jtd.getData("studentData", "emailID");
		String otp = jtd.getData("studentData", "otp");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		RolePage rolePage = new RolePage(driver);
		rolePage.selectStudent();

		WelcomePage welcomePage = rolePage.clickNextBtn();
		welcomePage.setprofilePicture(1);
		Thread.sleep(10000);
	}

}
