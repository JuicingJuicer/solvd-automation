package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooProductServicePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooProductServicePage extends YahooProductServicePageBase {

    @FindBy(xpath = ".//div[@id=\"Col1-0-Everything-Proxy\"]/div/div[2]/a")
    private ExtendedWebElement chooseCountryLink;

    public YahooProductServicePage(WebDriver driver) {
        super(driver);
        setPageURL("/everything/");
    }

    @Override
    public void clickChooseCountry() {
        chooseCountryLink.scrollTo();
        chooseCountryLink.click();
    }
}
