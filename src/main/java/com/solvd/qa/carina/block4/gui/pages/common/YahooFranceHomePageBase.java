package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooFranceHomePageBase extends AbstractPage {
    public YahooFranceHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getTrendingNowInFrench();
}
