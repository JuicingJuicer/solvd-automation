package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BatterySaverPageBase extends AbstractPage {
    public BatterySaverPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void saverSwitchOn();

    public abstract void goBack();
}
