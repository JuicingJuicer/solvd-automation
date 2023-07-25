package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooHomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooHomePage extends YahooHomePageBase {

    @FindBy(xpath = "//div[@class='weather-card-content Pos(r)']/a")
    private ExtendedWebElement seeMoreWeatherButton;

    @FindBy(xpath = ".//div[@id='module-weather']//h4")
    private ExtendedWebElement weatherCity;

    @FindBy(xpath = "//div[@id='ybar-search-box-container']//input[@type='text']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//div[@id='ybar-search-box-container']//button[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//a[@id=\"root_8\"]")
    private ExtendedWebElement productServiceLink;

    @FindBy(xpath = "//*[@id=\"root_3\"]")
    private ExtendedWebElement financeLink;

    //*[@id="root_5"]
    @FindBy(xpath = "//*[@id=\"root_5\"]")
    private ExtendedWebElement entertainmentLink;

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YahooWeatherPage openWeather() {
        seeMoreWeatherButton.click();
        return new YahooWeatherPage(driver);
    }

    @Override
    public String getWeatherCity() {
        return weatherCity.getText();
    }

    @Override
    public void search(String prompt) {
        searchBar.click();
        searchBar.type(prompt);
        searchButton.click();
    }

    @Override
    public YahooMovieSearchPage searchMovie(String search) {
        search(search);
        return new YahooMovieSearchPage(driver);
    }

    @Override
    public YahooProductServicePage openProductService() {
        productServiceLink.click();
        return new YahooProductServicePage(driver);
    }

    @Override
    public YahooFinancePage openFinance() {
        financeLink.click();
        return new YahooFinancePage(driver);
    }

    @Override
    public YahooEntertainmentPage openEntertainment() {
        entertainmentLink.click();
        return new YahooEntertainmentPage(driver);
    }
}
