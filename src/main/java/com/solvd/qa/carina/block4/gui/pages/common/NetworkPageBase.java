package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class NetworkPageBase extends AbstractPage {
    public NetworkPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void airplaneModeSwitchOn();

    public abstract String readInternetSubheader();

    public abstract String readCallSubheader();

    public abstract boolean isSimEnabled();

    public abstract boolean airplaneModeSwitchStatus();
}
