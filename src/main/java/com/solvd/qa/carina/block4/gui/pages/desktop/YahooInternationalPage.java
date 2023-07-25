package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooInternationalPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooInternationalPage extends YahooInternationalPageBase {

    @FindBy(xpath = "//*[@id=\"Col1-0-World-Proxy\"]//*[contains (text(), 'France')]")
    private ExtendedWebElement franceLink;

    public YahooInternationalPage(WebDriver driver) {
        super(driver);
        setPageURL("/everything/world");
    }

    @Override
    public YahooFranceHomePage openFrancePage() {
        franceLink.click();
        return new YahooFranceHomePage(driver);
    }
}