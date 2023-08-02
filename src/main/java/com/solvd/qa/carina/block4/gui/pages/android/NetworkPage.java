package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.NetworkPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NetworkPageBase.class)
public class NetworkPage extends NetworkPageBase {
    @FindBy(id = "com.android.settings:id/collapsing_toolbar")
    private ExtendedWebElement networkHeader;

    @FindBy(xpath = "//android.widget.TextView[@text='Internet']/following-sibling::android.widget.TextView")
    private ExtendedWebElement internetSubheader;

    @FindBy(xpath = "//android.widget.TextView[@text='Calls & SMS']/following-sibling::android.widget.TextView")
    private ExtendedWebElement callSubheader;

    @FindBy(xpath = "//android.widget.TextView[@text='SIMs']")
    private ExtendedWebElement sim;

    @FindBy(id = "android:id/switch_widget")
    private ExtendedWebElement airplaneModeSwitch;

    public NetworkPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(networkHeader);
    }

    @Override
    public void airplaneModeSwitchOn() {
        if (!airplaneModeSwitch.isChecked()) {
            airplaneModeSwitch.click();
        }
    }

    @Override
    public String readInternetSubheader() {
        return internetSubheader.getText();
    }

    @Override
    public String readCallSubheader() {
        return callSubheader.getText();
    }

    @Override
    public boolean isSimEnabled() {
        return Boolean.parseBoolean(sim.getAttribute("enabled"));
    }

    @Override
    public boolean airplaneModeSwitchStatus() {
        return airplaneModeSwitch.isChecked();
    }
}
