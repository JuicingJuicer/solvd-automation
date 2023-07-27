package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooHomePageBase extends AbstractPage {
    public YahooHomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooWeatherPageBase openWeather();

    public abstract String getWeatherCity();

    public abstract void search(String prompt);

    public abstract YahooMovieSearchPageBase searchMovie(String prompt, String link);

    public abstract YahooProductServicePageBase openProductService();

    public abstract YahooFinancePageBase openFinance();

    public abstract YahooEntertainmentPageBase openEntertainment();
}
