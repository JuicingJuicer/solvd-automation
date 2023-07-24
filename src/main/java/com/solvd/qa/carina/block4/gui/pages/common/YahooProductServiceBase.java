package com.solvd.qa.carina.block4.gui.pages.common;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooInternationalPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooProductServiceBase extends AbstractPage {

    public YahooProductServiceBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooInternationalPage openInternationalPage();
}
