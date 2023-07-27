package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooWeatherPageBase extends AbstractPage {
    public YahooWeatherPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readCity();
}
