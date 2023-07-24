package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenu;
import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenuBase;
import com.solvd.qa.carina.block4.gui.pages.common.YahooLifeBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooLifePage extends YahooLifeBase {

    @FindBy(xpath = "//*[@id=\"ybar-inner-wrap\"]/div[1]")
    private HeaderMenu headerMenu;

    public YahooLifePage(WebDriver driver) {
        super(driver);
    }

    public YahooLifePage(WebDriver driver, String path) {
        super(driver);
        setPageURL(path);
    }

    @Override
    public HeaderMenuBase getHeaderMenu() {
        return headerMenu;
    }
}
