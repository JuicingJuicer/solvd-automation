package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenu;
import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenuBase;
import com.solvd.qa.carina.block4.gui.pages.common.YahooEntertainmentBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooEntertainmentPage extends YahooEntertainmentBase {

    @FindBy(xpath = "//*[@id=\"ybar-inner-wrap\"]/div[1]")
    private HeaderMenu headerMenu;

    public YahooEntertainmentPage(WebDriver driver) {
        super(driver);
    }

    public YahooEntertainmentPage(WebDriver driver, String path) {
        super(driver);
        setPageURL(path);
    }

    @Override
    public HeaderMenuBase getHeaderMenu() {
        return headerMenu;
    }
}
