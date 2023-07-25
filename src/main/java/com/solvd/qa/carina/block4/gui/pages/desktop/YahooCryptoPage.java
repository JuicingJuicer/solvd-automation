package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooCryptoPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class YahooCryptoPage extends YahooCryptoPageBase {

    @FindBy(xpath = "//*[@id='YDC-Lead']//a[@data-test]")
    private List<ExtendedWebElement> cryptocurrencies;

    public YahooCryptoPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://finance.yahoo.com/crypto/");
    }

    @Override
    public YahooCryptoQuotePage searchCrypto(String name) {
        for (ExtendedWebElement item : cryptocurrencies) {
            if (item.getText().equals(name)) {
                item.click();
                return new YahooCryptoQuotePage(driver);
            }
        }
        return null;
    }
}
