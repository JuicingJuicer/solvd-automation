package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.DateAndTimePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DateAndTimePageBase.class)
public class DateAndTimePage extends DateAndTimePageBase {

    @FindBy(id = "com.android.settings:id/collapsing_toolbar")
    private ExtendedWebElement dateAndTimeHeader;

    @FindBy(xpath = "//android.widget.TextView[@text='Time']/following-sibling::android.widget.TextView")
    private ExtendedWebElement time;

    @FindBy(xpath = "//android.widget.LinearLayout[4]/following-sibling::android.widget.LinearLayout[1]//android.widget.Switch")
    private ExtendedWebElement setAutoSwitch;

    @FindBy(xpath = "//android.widget.LinearLayout[7]")
    private ExtendedWebElement timeZone;

    public DateAndTimePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(dateAndTimeHeader);
    }

    @Override
    public int readTimeHours() {
        String[] split = time.getText().split(":");
        return Integer.parseInt(split[0]);
    }

    @Override
    public int addHoursCheck(int base, int hour) {
        if ((base + hour) > 12) {
            return base + hour - 12;
        }
        return base + hour;
    }

    @Override
    public void timeZoneAutoSwitchOff() {
        if (setAutoSwitch.isChecked()) {
            setAutoSwitch.click();
        }
    }

    @Override
    public void clickTimeZone() {
        timeZone.click();
    }
}
