package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DateAndTimePageBase extends AbstractPage {
    public DateAndTimePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract int readTimeHours();

    public abstract int addHoursCheck(int base, int hour);

    public abstract void timeZoneAutoSwitchOff();

    public abstract void clickTimeZone();
}
