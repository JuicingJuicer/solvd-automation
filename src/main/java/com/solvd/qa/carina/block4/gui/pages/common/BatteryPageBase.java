package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class BatteryPageBase extends AbstractPage {

    public BatteryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void percentSwitchOn();

    public abstract boolean percentSwitchStatus();

    public abstract void clickBatterySaver();
}
