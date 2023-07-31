package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class TimeZonePageBase extends AbstractPage {
    public TimeZonePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickBack();

    public abstract void clickTimeZone();

    public abstract void selectWestTimeZone();

    public abstract void selectEastTimeZone();
}
