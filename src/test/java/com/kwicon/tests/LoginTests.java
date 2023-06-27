package com.kwicon.tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kwicon.base.BaseTest;
import com.kwicon.objects.android.HomePage;
import com.kwicon.objects.android.MainLoginPage;
import com.kwicon.objects.android.MyProfilePage;
import com.kwicon.objects.android.TypeEmailPage;
import com.kwicon.objects.android.VerifyPage;
import com.kwicon.objects.android.WalkThroughPage;
import com.kwicon.utils.json.JSONTestData;

public class LoginTests extends BaseTest {

	JSONTestData jtd = new JSONTestData("login");

	@Test(priority = 1)
	public void validatePrivacyPage() {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();
		Assert.assertEquals(mainLoginPage.clickOnPrivacy(), true);
		mainLoginPage.BackButtonPrivacy();
		Assert.assertEquals(mainLoginPage.getPageTitle(), true);
	}

	@Test(priority = 2)
	public void validateTermsPage() {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();
		Assert.assertEquals(mainLoginPage.clickOnTerms(), true);
		mainLoginPage.BackButtonPrivacy();
		Assert.assertEquals(mainLoginPage.getPageTitle(), true);

	}

	@Test(priority = 3)
	public void loginWithInvalidEmail() throws InterruptedException {

		String email = jtd.getData("invalidEmail", "emailID");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);
		typeEmailPage.clickContinue();
		Assert.assertEquals(typeEmailPage.invalidEmailToastMsg(), "Invalid mail. Please try again.");

	}

	@Test(priority = 4)
	public void loginWithInvalidOtp() throws InterruptedException {

		String email = jtd.getData("invalidOtp", "emailID");
		String otp = jtd.getData("invalidOtp", "otp");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();
		Assert.assertEquals(verifyPage.invalidCodeMsg(), "Invalid code. Please check your spam or tap on resend.");

	}

	@Test(priority = 5)
	public void loginWithValidEmail() throws InterruptedException {

		String email = jtd.getData("login", "emailID");
		String otp = jtd.getData("login", "otp");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		HomePage homePage = new HomePage(driver);
		assertEquals(true, homePage.logoDisplayed());
		homePage.logoutToLogin();
	}

	/*
	 * This method will select a static mail account from emulator device
	 * 
	 */
	@Test(priority = 6)
	public void loginWithGoogle() {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();
		mainLoginPage.continueWithGoogle();

		HomePage homePage = new HomePage(driver);
		assertEquals(true, homePage.logoDisplayed());
		homePage.logoutToLogin();
	}

	@Test(priority = 7)
	public void validateProfileName() {
		String email = jtd.getData("login", "emailID");
		String otp = jtd.getData("login", "otp");
		String profileName = jtd.getData("login", "profileName");

		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();

		TypeEmailPage typeEmailPage = mainLoginPage.clickEmail();
		typeEmailPage.setEmail(email);

		VerifyPage verifyPage = typeEmailPage.clickContinue();
		verifyPage.enterCode(otp);
		verifyPage.clickVerify();

		HomePage homePage = new HomePage(driver);
		MyProfilePage myProfilePage = homePage.openMyprofile();
		boolean flag = myProfilePage.compareProfileName(profileName);
		Assert.assertEquals(flag, true);
		myProfilePage.gobackToHome();
		homePage.logoutToLogin();
		
	}

}
