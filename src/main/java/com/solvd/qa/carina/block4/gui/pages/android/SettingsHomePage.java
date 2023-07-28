package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.SettingsHomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SettingsHomePageBase.class)
public class SettingsHomePage extends SettingsHomePageBase {

    @FindBy(id = "com.android.settings:id/homepage_title")
    private ExtendedWebElement settingsHomeTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Accessibility']")
    private ExtendedWebElement accessibility;

    @FindBy(id = "com.android.settings:id/search_action_bar")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//android.widget.TextView[@text='Battery']")
    private ExtendedWebElement battery;

    public SettingsHomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(settingsHomeTitle);
    }

    @Override
    public void clickAccessibility() {
        accessibility.scrollTo();
        accessibility.click();
    }

    @Override
    public void clickSearchBar() {
        searchBar.click();
    }

    @Override
    public void clickBattery() {
        battery.scrollTo();
        battery.click();
    }
}
