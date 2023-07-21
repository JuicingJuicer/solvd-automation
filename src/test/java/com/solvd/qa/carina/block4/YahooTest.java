package com.solvd.qa.carina.block4;

import com.solvd.qa.carina.block4.gui.pages.desktop.YahooHomePage;
import com.solvd.qa.carina.block4.gui.pages.desktop.YahooMovieSearchPage;
import com.solvd.qa.carina.block4.gui.pages.desktop.YahooWeatherPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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

    @Test
    @TestPriority(Priority.P3)
    public void testBarbOpp() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        YahooMovieSearchPage barbie = homePage.searchBarbie();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(barbie.readTitle(), "Barbie (film)", "Invalid title");
        softAssert.assertEquals(barbie.readReleaseDate(), "Release date: July 21, 2023", "Invalid release date");
        softAssert.assertEquals(barbie.readDirector(), "Greta Gerwig", "Invalid director");

        homePage = barbie.goHome();
        YahooMovieSearchPage oppenheimer = homePage.searchOppenheimer();

        softAssert.assertEquals(barbie.readTitle(), "Oppenheimer (film)", "Invalid title");
        softAssert.assertEquals(barbie.readReleaseDate(), "Release date: July 21, 2023", "Invalid release date");
        softAssert.assertEquals(barbie.readDirector(), "Christopher Nolan", "Invalid director");

        softAssert.assertAll();
    }
}
