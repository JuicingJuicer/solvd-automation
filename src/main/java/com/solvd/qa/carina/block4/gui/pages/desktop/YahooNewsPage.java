package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenu;
import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenuBase;
import com.solvd.qa.carina.block4.gui.pages.common.YahooNewsBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooNewsPage extends YahooNewsBase {
    @FindBy(xpath = "//*[@id=\"ybar-inner-wrap\"]/div[1]")
    private HeaderMenu headerMenu;

    public YahooNewsPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://news.yahoo.com/");
    }

    @Override
    public HeaderMenuBase getHeaderMenu() {
        return headerMenu;
    }
}
