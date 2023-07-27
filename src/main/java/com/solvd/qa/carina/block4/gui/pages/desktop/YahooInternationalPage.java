package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooInternationalPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YahooInternationalPage extends YahooInternationalPageBase {

    @FindBy(xpath = ".//div[@id=\"Col1-0-World-Proxy\"]//a")
    private List<ExtendedWebElement> countries;

    public YahooInternationalPage(WebDriver driver) {
        super(driver);
        setPageURL("/everything/world");
    }

    @Override
    public YahooCountryHomePage selectCountry(String name, String link) {
        for (ExtendedWebElement country : countries) {
            if (country.getText().equals(name)) {
                country.scrollTo();
                country.click();
                return new YahooCountryHomePage(driver, link);
            }
        }
        return null;
    }
}