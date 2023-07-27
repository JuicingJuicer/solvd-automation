package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooCountryHomePageBase extends AbstractPage {
    public YahooCountryHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTrendingNow();
}
