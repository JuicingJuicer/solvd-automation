package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooFranceHomePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooFranceHomePage extends YahooFranceHomePageBase {

    @FindBy(xpath = "//*[@id=\"module-trending\"]//h3")
    private ExtendedWebElement trendingNowInFrench;

    @FindBy(xpath = "//*[@id=\"consent-page\"]//div[@class='actions couple']//button[1]")
    private ExtendedWebElement acceptCookies;

    public YahooFranceHomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://fr.yahoo.com/?p=dnr");
        acceptCookies.clickIfPresent();
    }

    public String getTrendingNowInFrench() {
        return trendingNowInFrench.getText();
    }
}
