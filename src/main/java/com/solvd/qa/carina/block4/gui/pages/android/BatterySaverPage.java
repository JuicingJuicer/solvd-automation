package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.BatterySaverPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class BatterySaverPage extends BatterySaverPageBase {
    @FindBy(id = "android.widget.ImageButton")
    private ExtendedWebElement backButton;

    @FindBy(id = "android:id/switch_widget")
    private ExtendedWebElement saverSwitch;

    public BatterySaverPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(backButton);
    }

    @Override
    public void saverSwitchOn() {
        if (!saverSwitch.isChecked()) {
            saverSwitch.click();
        }
    }

    @Override
    public void goBack() {
        backButton.click();
    }
}