package com.kwicon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kwicon.base.BaseTest;
import com.kwicon.objects.android.MainLoginPage;
import com.kwicon.objects.android.WalkThroughPage;

public class WalkthroughTests extends BaseTest {

	
	@Test(priority = 1)
	public void validateWalkthroughSlideOne() throws InterruptedException {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		Assert.assertEquals(walkThroughPage.validateSlideOne(), true);
	}

	@Test(priority = 2)
	public void validateWalkthroughSlideTwo() throws InterruptedException {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		walkThroughPage.clickNextOnce();
		Assert.assertEquals(walkThroughPage.validateSlideTwo(), true);
	}

	@Test(priority = 3)
	public void validateWalkthroughSlideThree() throws InterruptedException {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		walkThroughPage.clickNextOnce();
		walkThroughPage.clickNextOnce();
		Assert.assertEquals(walkThroughPage.validateSlideThree(), true);
	}

	@Test(priority = 4)
	public void usingSkip() throws InterruptedException {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.skipToLogin();
		Assert.assertEquals(mainLoginPage.getKwiconLogo(), true);

	}

	@Test(priority = 5)
	public void usingNext() throws InterruptedException {
		WalkThroughPage walkThroughPage = new WalkThroughPage(driver);
		MainLoginPage mainLoginPage = walkThroughPage.nextToLogin();
		Assert.assertEquals(mainLoginPage.getKwiconLogo(), true);

	}
}
