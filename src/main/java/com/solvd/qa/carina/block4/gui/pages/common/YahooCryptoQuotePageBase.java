package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooCryptoQuotePageBase extends AbstractPage {
    public YahooCryptoQuotePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readName();

    public abstract String readDate();
}
