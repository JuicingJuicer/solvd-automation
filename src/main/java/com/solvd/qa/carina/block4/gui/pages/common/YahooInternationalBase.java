package com.solvd.qa.carina.block4.gui.pages.common;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooFranceHomePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooInternationalBase extends AbstractPage {
    public YahooInternationalBase(WebDriver driver) {
        super(driver);
    }

    public abstract YahooFranceHomePage openFrancePage();
}
