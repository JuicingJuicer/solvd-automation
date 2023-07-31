package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.SettingsHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsHomePageBase.class)
public class SettingsHomePage extends SettingsHomePageBase implements IMobileUtils {

    @FindBy(id = "com.android.settings:id/homepage_title")
    private ExtendedWebElement settingsHomeTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='System']")
    private ExtendedWebElement system;

    @FindBy(id = "com.android.settings:id/search_action_bar")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Battery']")
    private ExtendedWebElement battery;

    @FindBy(xpath = "//android.widget.TextView[@text='Network & internet']")
    private ExtendedWebElement network;

    @FindBy(xpath = "//android.widget.TextView[@text='Storage']")
    private ExtendedWebElement storage;

    @FindBy(xpath = "//android.widget.TextView[@text='Storage']/following-sibling::android.widget.TextView")
    private ExtendedWebElement storageSubheader;


    public SettingsHomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(settingsHomeTitle);
    }

    @Override
    public void clickSystem() {
        swipe(system);
        system.click();
    }

    @Override
    public void clickSearchBar() {
        searchBar.click();
    }

    @Override
    public void clickBattery() {
        battery.click();
    }

    @Override
    public void clickNetwork() {
        network.click();
    }

    @Override
    public void clickStorage() {
        storage.click();
    }

    @Override
    public double readStorageSubheaderSize() {
        String s = storageSubheader.getText();
        int startIndex = s.indexOf('-') + 1;
        int endIndex = s.indexOf("GB") - 1;
        String sub = s.substring(startIndex, endIndex).trim();
        return Double.parseDouble(sub);
    }
}
