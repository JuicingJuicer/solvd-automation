package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooFinancePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooFinancePage extends YahooFinancePageBase {

    @FindBy(xpath = "//*[@id=\"Nav-0-DesktopNav-0-DesktopNav\"]//li[9]/a")
    private ExtendedWebElement cryptoLink;

    @FindBy(xpath = "//*[@id=\"myLightboxContainer\"]/button")
    private ExtendedWebElement popUpClose;

    public YahooFinancePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://finance.yahoo.com/");
        popUpClose.clickIfPresent();
    }

    @Override
    public YahooCryptoPage openCrypto() {
        cryptoLink.click();
        return new YahooCryptoPage(driver);
    }
}
