package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooCryptoPageBase extends AbstractPage {
    public YahooCryptoPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooCryptoQuotePageBase searchCrypto(String name);
}
