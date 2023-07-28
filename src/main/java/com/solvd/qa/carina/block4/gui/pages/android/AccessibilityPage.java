package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.AccessibilityPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccessibilityPageBase.class)
public class AccessibilityPage extends AccessibilityPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Flash notifications']")
    private ExtendedWebElement flashNoti;

    public AccessibilityPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(flashNoti);
    }

    @Override
    public void clickFlashNoti() {
        flashNoti.scrollTo();
        flashNoti.click();
    }
}
