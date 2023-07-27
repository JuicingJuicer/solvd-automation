package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class YahooMovieSearchPageBase extends AbstractPage {
    public YahooMovieSearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String readTitle();

    public abstract String readReleaseDate();

    public abstract String readDirector();

    public abstract YahooHomePageBase goHome();
}
