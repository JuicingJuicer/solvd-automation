package com.solvd.qa.carina.block4.gui.pages.common;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooMovieSearchPage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooHomeBase extends AbstractPage {
    public YahooHomeBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooWeatherBase openWeather();

    public abstract String getWeatherCity();

    public abstract void search(String prompt);

    public abstract YahooMovieSearchPage searchBarbie();

    public abstract YahooMovieSearchPage searchOppenheimer();
}
