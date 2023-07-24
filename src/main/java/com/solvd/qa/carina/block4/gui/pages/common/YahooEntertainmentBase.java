package com.solvd.qa.carina.block4.gui.pages.common;

import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooEntertainmentBase extends AbstractPage {
    public YahooEntertainmentBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderMenuBase getHeaderMenu();
}
