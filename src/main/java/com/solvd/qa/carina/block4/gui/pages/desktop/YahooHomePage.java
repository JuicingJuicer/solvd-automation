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

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public YahooWeatherPage openWeather() {
        SeeMoreWeatherButton.hover();
        SeeMoreWeatherButton.click();
        return new YahooWeatherPage(driver);
    }

    public String getWeatherCity() {
        return weatherCity.getText();
    }
}
