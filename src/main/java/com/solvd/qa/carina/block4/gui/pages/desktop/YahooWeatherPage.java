package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooWeatherBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooWeatherPage extends YahooWeatherBase {

    @FindBy(xpath = "//div[@id='module-location-heading']//h1")
    private ExtendedWebElement city;

    public YahooWeatherPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String readCity() {
        return city.getText();
    }
}
