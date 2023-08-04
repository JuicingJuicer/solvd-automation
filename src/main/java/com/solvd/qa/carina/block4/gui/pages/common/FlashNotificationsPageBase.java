package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class FlashNotificationsPageBase extends AbstractPage {
    public FlashNotificationsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickScreenFlash();

    public abstract String readColorSummary();

    public abstract void selectColor(String choice);

    public abstract void clickDone();
}
