package com.solvd.qa.carina.block4.gui.components.footer;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooEntertainmentPage;
import com.solvd.qa.carina.block4.gui.pages.desktop.YahooLifePage;
import com.solvd.qa.carina.block4.gui.pages.desktop.YahooNewsPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends HeaderMenuBase {

    @FindBy(xpath = "//*[@id=\"ybar-topnavigation\"]/ul/li[3]//a")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "//*[@id=\"ybar-topnavigation\"]/ul/li[6]//a")
    private ExtendedWebElement entertainnmentLink;

    @FindBy(xpath = "//*[@id=\"ybar-topnavigation\"]/ul/li[7]//a")
    private ExtendedWebElement lifeLink;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public YahooNewsPage openNewsPage() {
        newsLink.click();
        return new YahooNewsPage(driver, "https://news.yahoo.com/");
    }

    @Override
    public YahooEntertainmentPage openEntertainmentPage() {
        entertainnmentLink.click();
        return new YahooEntertainmentPage(driver, "/entertainment/");
    }

    @Override
    public YahooLifePage openLifePage() {
        lifeLink.click();
        return new YahooLifePage(driver, "/lifestyle/");
    }
}
