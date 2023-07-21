package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooHomeBase extends AbstractPage {
    public YahooHomeBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooWeatherBase openWeather();
}
