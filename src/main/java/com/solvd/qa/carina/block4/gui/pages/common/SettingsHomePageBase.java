package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SettingsHomePageBase extends AbstractPage {
    public SettingsHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickSystem();

    public abstract void clickSearchBar();

    public abstract void clickBattery();

    public abstract void clickNetwork();

    public abstract void clickStorage();

    public abstract double readStorageSubheaderSize();
}
