package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.pages.common.YahooMovieSearchPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooMovieSearchPage extends YahooMovieSearchPageBase {

    @FindBy(xpath = "//h4[@class='text-module u-strong ']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//li[@class='mb-12'][1]")
    private ExtendedWebElement releaseDate;

    @FindBy(xpath = "//li[@class='mb-12'][2]/a")
    private ExtendedWebElement director;

    @FindBy(xpath = "//a[@id='yucs-apps_button']")
    private ExtendedWebElement yahooSites;

    @FindBy(xpath = "//span[@class='uha-ico uha-home']")
    private ExtendedWebElement homeButton;

    public YahooMovieSearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String readTitle() {
        return title.getText();
    }

    @Override
    public String readReleaseDate() {
        return releaseDate.getText();
    }

    @Override
    public String readDirector() {
        return director.getText();
    }

    @Override
    public YahooHomePage goHome() {
        yahooSites.click();
        homeButton.click();
        return new YahooHomePage(driver);
    }
}
