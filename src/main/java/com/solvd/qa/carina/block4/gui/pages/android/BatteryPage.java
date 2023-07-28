package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.BatteryPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BatteryPageBase.class)
public class BatteryPage extends BatteryPageBase {
    @FindBy(id = "com.android.settings:id/usage_summary")
    private ExtendedWebElement batteryPercentage;

    @FindBy(id = "android:id/switch_widget")
    private ExtendedWebElement percentSwitch;

    @FindBy(xpath = "//android.widget.TextView[@text='Battery Saver']")
    private ExtendedWebElement batterySaver;

    public BatteryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return batteryPercentage.isElementPresent();
    }

    @Override
    public void percentSwitchOn() {
        if (percentSwitch.getAttribute("checked").equals("false")) {
            percentSwitch.click();
        }
    }

    @Override
    public boolean percentSwitchStatus() {
        return Boolean.parseBoolean(percentSwitch.getAttribute("checked"));
    }

    @Override
    public void clickBatterySaver() {
        batterySaver.click();
    }
}
