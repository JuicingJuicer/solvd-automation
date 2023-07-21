package com.solvd.qa.carina.block4.gui.pages.common;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooHomePage;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooMovieSearchBase extends AbstractPage {
    public YahooMovieSearchBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readTitle();

    public abstract String readReleaseDate();

    public abstract String readDirector();

    public abstract YahooHomePage goHome();
}
