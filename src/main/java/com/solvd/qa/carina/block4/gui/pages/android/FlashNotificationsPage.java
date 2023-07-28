package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.FlashNotificationsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FlashNotificationsPageBase.class)
public class FlashNotificationsPage extends FlashNotificationsPageBase {

    @FindBy(xpath = "//android.widget.TextView[@text='Screen flash']")
    private ExtendedWebElement screenFlash;

    @FindBy(id = "android:id/summary")
    private ExtendedWebElement colorSummary;

    @FindBy(xpath = "//android.widget.RadioButton")
    private List<ExtendedWebElement> colors;

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement done;

    public FlashNotificationsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return screenFlash.isElementPresent();
    }

    @Override
    public void clickScreenFlash() {
        screenFlash.click();
    }

    @Override
    public String readColorSummary() {
        return colorSummary.getText();
    }

    @Override
    public void selectColor(String choice) {
        for (ExtendedWebElement color : colors) {
            if (color.getAttribute("content-desc").equals(choice)) {
                color.click();
                done.click();
                break;
            }
        }
    }

    @Override
    public void clickDone() {
        done.click();
    }
}
