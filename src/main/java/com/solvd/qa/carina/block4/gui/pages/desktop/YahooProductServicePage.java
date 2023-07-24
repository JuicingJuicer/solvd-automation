package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooProductServiceBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooProductServicePage extends YahooProductServiceBase {

    @FindBy(xpath = "//*[@id=\"Col1-0-Everything-Proxy\"]/div/div[2]/a")
    private ExtendedWebElement chooseCountryLink;

    public YahooProductServicePage(WebDriver driver) {
        super(driver);
        setPageURL("/everything/");
    }

    @Override
    public YahooInternationalPage openInternationalPage() {
        chooseCountryLink.scrollTo();
        chooseCountryLink.click();
        return new YahooInternationalPage(driver);
    }
}
