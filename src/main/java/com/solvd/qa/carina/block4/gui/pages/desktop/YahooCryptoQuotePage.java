package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooCryptoQuotePageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooCryptoQuotePage extends YahooCryptoQuotePageBase {

    @FindBy(xpath = ".//div[@id=\"quote-header-info\"]//h1")
    private ExtendedWebElement name;

    @FindBy(xpath = ".//div[@id='quote-summary']//td[@data-test='START_DATE-value']")
    private ExtendedWebElement date;

    public YahooCryptoQuotePage(WebDriver driver, String ticker) {
        super(driver);
        setPageAbsoluteURL("https://finance.yahoo.com/quote/" + ticker + "?p=" + ticker);
    }

    @Override
    public String readName() {
        return name.getText();
    }

    @Override
    public String readDate() {
        return date.getText();
    }
}
