package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooHomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooHomePage extends YahooHomePageBase {

    @FindBy(xpath = ".//div[@class='weather-card-content Pos(r)']/a")
    private ExtendedWebElement seeMoreWeatherButton;

    @FindBy(xpath = ".//div[@id='module-weather']//h4")
    private ExtendedWebElement weatherCity;

    @FindBy(xpath = ".//div[@id='ybar-search-box-container']//input[@type='text']")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = ".//div[@id='ybar-search-box-container']//button[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = ".//a[@id=\"root_8\"]")
    private ExtendedWebElement productServiceLink;

    @FindBy(xpath = ".//a[@id=\"root_3\"]")
    private ExtendedWebElement financeLink;

    @FindBy(xpath = ".//a[@id=\"root_5\"]")
    private ExtendedWebElement entertainmentLink;

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSeeMore() {
        seeMoreWeatherButton.click();
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
    public YahooMovieSearchPage searchMovie(String prompt, String link) {
        search(prompt);
        return new YahooMovieSearchPage(driver, link);
    }

    @Override
    public void clickProductService() {
        productServiceLink.click();
    }

    @Override
    public void clickFinance() {
        financeLink.click();
    }

    @Override
    public void clickEntertainment() {
        entertainmentLink.click();
    }
}
