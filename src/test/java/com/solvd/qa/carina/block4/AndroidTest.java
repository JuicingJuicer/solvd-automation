package com.solvd.qa.carina.block4;

import com.solvd.qa.carina.block4.gui.pages.common.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AndroidTest implements IAbstractTest, IAbstractDataProvider {

    @Test
    public void testBatterySettings() {
        // open settings
        SettingsHomePageBase settingHomePage = initPage(getDriver(), SettingsHomePageBase.class);
        Assert.assertTrue(settingHomePage.isPageOpened(), "Settings home page isn't opened");

        // click battery button to open battery page
        settingHomePage.clickBattery();
        BatteryPageBase batteryPage = initPage(getDriver(), BatteryPageBase.class);
        Assert.assertTrue(batteryPage.isPageOpened(), "Battery page isn't opened");

        // turn on battery percent switch
        batteryPage.percentSwitchOn();

        // verify if battery percent switch is turned on
        Assert.assertTrue(batteryPage.percentSwitchStatus(), "Battery percent switch isn't on");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/Colors.xlsx", sheet = "Colors", dsUid = "TUID", dsArgs = "name")
    public void testScreenFlashColor(String name) {
        // open settings
        SettingsHomePageBase settingHomePage = initPage(getDriver(), SettingsHomePageBase.class);
        Assert.assertTrue(settingHomePage.isPageOpened(), "Settings home page isn't opened");

        // click searchbar to open search page
        settingHomePage.clickSearchBar();
        SearchPageBase searchPage = initPage(getDriver(), SearchPageBase.class);
        Assert.assertTrue(searchPage.isPageOpened(), "Search page isn't opened");

        // search and select 'screen flash' to open flash notifications page
        searchPage.search("screen flash");
        FlashNotificationsPageBase flashNotificationsPage = initPage(getDriver(), FlashNotificationsPageBase.class);
        Assert.assertTrue(flashNotificationsPage.isPageOpened(), "Flash notifications page isn't opened");

        // click screen flash button to open color selector to select color
        flashNotificationsPage.clickScreenFlash();
        flashNotificationsPage.selectColor(name);
        flashNotificationsPage.clickDone();

        // verify the color summary with expected color
        Assert.assertEquals(flashNotificationsPage.readColorSummary(), name, "Wrong color selected");
    }

    @Test
    public void testAirplaneMode() {
        // open settings
        SettingsHomePageBase settingHomePage = initPage(getDriver(), SettingsHomePageBase.class);
        Assert.assertTrue(settingHomePage.isPageOpened(), "Settings home page isn't opened");

        // click network button to open network page
        settingHomePage.clickNetwork();
        NetworkPageBase networkPage = initPage(getDriver(), NetworkPageBase.class);
        Assert.assertTrue(networkPage.isPageOpened(), "Network page isn't opened");

        // turn on airplane mode and verify results with expected results
        networkPage.airplaneModeSwitchOn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(networkPage.readInternetSubheader(), "Airplane mode is on", "Airplane mode isn't on");
        softAssert.assertEquals(networkPage.readCallSubheader(), "T-Mobile (Temporarily unavailable)", "T-Mobile is available");
        softAssert.assertFalse(networkPage.isSimEnabled(), "Sim is enabled");
        softAssert.assertTrue(networkPage.airplaneModeSwitchStatus(), "Airplane mode switch isn't on");

        softAssert.assertAll();
    }

    @Test
    public void testWestToEastTimeZone() {
        // open settings
        SettingsHomePageBase settingHomePage = initPage(getDriver(), SettingsHomePageBase.class);
        Assert.assertTrue(settingHomePage.isPageOpened(), "Settings home page isn't opened");

        // click system button to open system page
        settingHomePage.clickSystem();
        SystemPageBase systemPage = initPage(getDriver(), SystemPageBase.class);
        Assert.assertTrue(systemPage.isPageOpened(), "System page isn't opened");

        // click date and time button to open date and time page
        systemPage.clickDateAndTime();
        DateAndTimePageBase dateAndTimePage = initPage(getDriver(), DateAndTimePageBase.class);
        Assert.assertTrue(dateAndTimePage.isPageOpened(), "Date and time page isn't opened");

        // turn off set auto switch
        dateAndTimePage.timeZoneAutoSwitchOff();

        // click time zone button to open time zone page
        dateAndTimePage.clickTimeZone();
        TimeZonePageBase timeZonePage = initPage(getDriver(), TimeZonePageBase.class);
        Assert.assertTrue(timeZonePage.isPageOpened(), "Time zone page isn't opened");

        // click time zone button to open time zone selection to select west time zone
        timeZonePage.clickTimeZone();
        timeZonePage.selectWestTimeZone();

        // click back to go back to date and time page
        timeZonePage.clickBack();
        DateAndTimePageBase dateAndTimePage2 = initPage(getDriver(), DateAndTimePageBase.class);
        Assert.assertTrue(dateAndTimePage2.isPageOpened(), "Date and time page isn't opened");

        // read hours of the western time zone
        int hours = dateAndTimePage.readTimeHours();

        // click time zone button to open time zone page
        dateAndTimePage2.clickTimeZone();
        TimeZonePageBase timeZonePage2 = initPage(getDriver(), TimeZonePageBase.class);
        Assert.assertTrue(timeZonePage2.isPageOpened(), "Time zone page isn't opened");

        // click time zone button to open time zone selection to select east time zone
        timeZonePage2.clickTimeZone();
        timeZonePage2.selectEastTimeZone();

        // click back to go back to date and time page
        timeZonePage2.clickBack();
        DateAndTimePageBase dateAndTimePage3 = initPage(getDriver(), DateAndTimePageBase.class);
        Assert.assertTrue(dateAndTimePage3.isPageOpened(), "Date and time page isn't opened");

        // verify if west to east time zone match time difference
        Assert.assertEquals(dateAndTimePage3.addHoursCheck(hours, 3), dateAndTimePage3.readTimeHours(), "Time is wrong");
    }

    @Test
    public void testStorageSize() {
        // open settings
        SettingsHomePageBase settingHomePage = initPage(getDriver(), SettingsHomePageBase.class);
        Assert.assertTrue(settingHomePage.isPageOpened(), "Settings home page isn't opened");

        // read available storage size
        Double availableStorage = settingHomePage.readStorageSubheaderSize();

        // click storage button to open storage page
        settingHomePage.clickStorage();
        StoragePageBase storagePage = initPage(getDriver(), StoragePageBase.class);
        Assert.assertTrue(storagePage.isPageOpened(), "Storage page isn't opened");

        // verify available storage by comparing the difference between storage size total and storage size used
        Assert.assertEquals(availableStorage, (storagePage.readStorageSizeTotal() - storagePage.readStorageSizeUsed()), "Available storage is wrong");
    }
}
