package com.solvd.qa.carina.block4.gui.pages.desktop;

import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenu;
import com.solvd.qa.carina.block4.gui.components.footer.HeaderMenuBase;
import com.solvd.qa.carina.block4.gui.components.footer.HoroscopeMenu;
import com.solvd.qa.carina.block4.gui.components.footer.HoroscopeMenuBase;
import com.solvd.qa.carina.block4.gui.pages.common.YahooLifePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class YahooLifePage extends YahooLifePageBase {

    @FindBy(xpath = "//*[@id=\"ybar-inner-wrap\"]/div[1]")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//*[@id=\"module-horoscope\"]/div")
    private HoroscopeMenu horoscopeMenu;

    public YahooLifePage(WebDriver driver) {
        super(driver);
        setPageURL("/lifestyle/");
    }

    @Override
    public HeaderMenuBase getHeaderMenu() {
        return headerMenu;
    }

    @Override
    public HoroscopeMenuBase getHoroscopeMenu() {
        return horoscopeMenu;
    }
}
