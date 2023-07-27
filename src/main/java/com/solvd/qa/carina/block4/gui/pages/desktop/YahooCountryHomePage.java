package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooCountryHomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooCountryHomePage extends YahooCountryHomePageBase {

    @FindBy(xpath = "//div[@id=\"module-trending\"]//h3")
    private ExtendedWebElement trendingNow;

    @FindBy(xpath = "//div[@id=\"consent-page\"]//div[@class='actions couple']//button[1]")
    private ExtendedWebElement acceptCookies;

    public YahooCountryHomePage(WebDriver driver, String link) {
        super(driver);
        setPageAbsoluteURL(link);
        acceptCookies.clickIfPresent();
    }

    public String getTrendingNow() {
        return trendingNow.getText();
    }
}
