package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.SystemPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SystemPageBase.class)
public class SystemPage extends SystemPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@text='Date & time']")
    private ExtendedWebElement dateAndTime;

    public SystemPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(dateAndTime);
    }

    @Override
    public void clickDateAndTime() {
        swipe(dateAndTime);
        dateAndTime.click();
    }
}
