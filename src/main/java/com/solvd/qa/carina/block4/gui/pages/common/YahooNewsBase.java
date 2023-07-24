package com.solvd.qa.carina.block4.gui.pages.common;

import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenuBase;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooNewsBase extends AbstractPage {
    public YahooNewsBase(WebDriver driver) {
        super(driver);
    }

    public abstract HeaderMenuBase getHeaderMenu();
}
