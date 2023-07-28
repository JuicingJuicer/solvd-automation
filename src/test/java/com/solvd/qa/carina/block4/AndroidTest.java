package com.solvd.qa.carina.block4;

import com.solvd.qa.carina.block4.gui.pages.common.BatteryPageBase;
import com.solvd.qa.carina.block4.gui.pages.common.FlashNotificationsPageBase;
import com.solvd.qa.carina.block4.gui.pages.common.SearchPageBase;
import com.solvd.qa.carina.block4.gui.pages.common.SettingsHomePageBase;
import com.zebrunner.carina.core.IAbstractTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidTest implements IAbstractTest {

    @Test
    public void testBatterySettings() {
        SettingsHomePageBase settingHomePage = initPage(getDriver(), SettingsHomePageBase.class);
        Assert.assertTrue(settingHomePage.isPageOpened(), "Settings home page isn't opened");

        settingHomePage.clickBattery();
        SoftAssert softAssert = new SoftAssert();
        BatteryPageBase batteryPage = initPage(getDriver(), BatteryPageBase.class);
        softAssert.assertTrue(batteryPage.isPageOpened(), "Battery page isn't opened");
        batteryPage.percentSwitchOn();
        softAssert.assertTrue(batteryPage.percentSwitchStatus(), "Battery percent switch isn't on");

        softAssert.assertAll();
    }

    // Will use data provider for this one
    @Test()
    public void testScreenFlashColor() {
        SettingsHomePageBase settingHomePage = initPage(getDriver(), SettingsHomePageBase.class);
        Assert.assertTrue(settingHomePage.isPageOpened(), "Settings home page isn't opened");

        settingHomePage.clickSearchBar();
        SearchPageBase searchPage = initPage(getDriver(), SearchPageBase.class);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page isn't opened");

        searchPage.search("screen flash");
        FlashNotificationsPageBase flashNotificationsPage = initPage(getDriver(), FlashNotificationsPageBase.class);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(flashNotificationsPage.isPageOpened(), "Flash notifications page isn't opened");
        flashNotificationsPage.clickScreenFlash();
        flashNotificationsPage.selectColor("Blue");
        flashNotificationsPage.clickDone();
        softAssert.assertEquals(flashNotificationsPage.readColorSummary(), "Blue", "Wrong color selected");

        softAssert.assertAll();
    }
}
