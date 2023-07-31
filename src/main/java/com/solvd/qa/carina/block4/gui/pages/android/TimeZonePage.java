package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.TimeZonePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = TimeZonePageBase.class)
public class TimeZonePage extends TimeZonePageBase implements IMobileUtils {

    @FindBy(id = "com.android.settings:id/collapsing_toolbar")
    private ExtendedWebElement timeZoneHeader;

    @FindBy(xpath = "//android.widget.TextView[@text='Time zone']")
    private ExtendedWebElement timeZoneButton;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
    private ExtendedWebElement back;

    @FindBy(xpath = "//android.widget.TextView[@text='Los Angeles']")
    private ExtendedWebElement westZone;

    @FindBy(xpath = "//android.widget.TextView[@text='New York']")
    private ExtendedWebElement eastZone;

    public TimeZonePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(timeZoneHeader);
    }

    @Override
    public void clickBack() {
        back.click();
    }

    @Override
    public void clickTimeZone() {
        timeZoneButton.click();
    }

    @Override
    public void selectWestTimeZone() {
        westZone.click();
        pause(1);
    }

    @Override
    public void selectEastTimeZone() {
        swipe(eastZone);
        eastZone.click();
        pause(1);
    }
}
