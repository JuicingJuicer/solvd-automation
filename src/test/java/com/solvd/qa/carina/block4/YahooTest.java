package com.solvd.qa.carina.block4;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooHomePage;
import com.solvd.qa.carina.block4.gui.pages.desktop.YahooWeatherPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class YahooTest implements IAbstractTest {
    @Test
    @TestPriority(Priority.P3)
    public void testCityWeather() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        String homeCity = homePage.getWeatherCity();

        YahooWeatherPage weatherPage = homePage.openWeather();
        assertEquals(homeCity, weatherPage.readCity(), "Invalid city!");
    }
}
