package com.solvd.qa.carina.block4.gui.components.footer;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooEntertainmentPage;
import com.solvd.qa.carina.block4.gui.pages.desktop.YahooLifePage;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class HeaderMenuBase extends AbstractUIObject {
    public HeaderMenuBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract YahooEntertainmentPage openEntertainmentPage();

    public abstract YahooLifePage openLifePage();
}
