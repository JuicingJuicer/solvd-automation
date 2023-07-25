package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooProductServicePageBase extends AbstractPage {

    public YahooProductServicePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooInternationalPageBase openInternationalPage();
}
