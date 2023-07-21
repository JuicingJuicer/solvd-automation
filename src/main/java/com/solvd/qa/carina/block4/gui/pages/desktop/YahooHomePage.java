package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooHomeBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooHomePage extends YahooHomeBase {

    @FindBy(xpath = "//div[@class='weather-card-content Pos(r)']/a")
    private ExtendedWebElement SeeMoreWeatherButton;

    @FindBy(xpath = ".//div[@id='module-weather']//h4")
    private ExtendedWebElement weatherCity;

    @FindBy(xpath = "//div[@id='ybar-search-box-container']//input[@type='text']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@id='ybar-search-box-container']//button[@type='submit']")
    private ExtendedWebElement searchButton;

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YahooWeatherPage openWeather() {
        SeeMoreWeatherButton.hover();
        SeeMoreWeatherButton.click();
        return new YahooWeatherPage(driver);
    }

    @Override
    public String getWeatherCity() {
        return weatherCity.getText();
    }

    @Override
    public void search(String prompt) {
        searchBar.hover();
        searchBar.click();
        searchBar.type(prompt);
        searchButton.hover();
        searchButton.click();
    }

    @Override
    public YahooMovieSearchPage searchBarbie() {
        search("barbie movie");
        return new YahooMovieSearchPage(driver);
    }

    @Override
    public YahooMovieSearchPage searchOppenheimer() {
        search("oppenheimer movie");
        return new YahooMovieSearchPage(driver);
    }
}
