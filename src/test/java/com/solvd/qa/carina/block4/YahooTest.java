package com.solvd.qa.carina.block4;

import com.solvd.qa.carina.block4.gui.pages.desktop.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.dataprovider.IAbstractDataProvider;
import com.zebrunner.carina.dataprovider.annotations.XlsDataSourceParameters;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class YahooTest implements IAbstractTest, IAbstractDataProvider {

    @Test
    @TestPriority(Priority.P3)
    public void testCityWeather() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        String homeCity = homePage.getWeatherCity();

        homePage.clickSeeMore();
        YahooWeatherPage weatherPage = new YahooWeatherPage(getDriver());
        Assert.assertTrue(weatherPage.isPageOpened(), "Weather page is not opened!");

        Assert.assertEquals(homeCity, weatherPage.readCity(), "Invalid city!");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/movies.xlsx", sheet = "Movies", dsUid = "TUID", dsArgs = "search, link, title, date, director")
    @TestPriority(Priority.P3)
    public void testMovieSearch(String search, String link, String title, String date, String director) {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        YahooMovieSearchPage moviePage = homePage.searchMovie(search, link);
        Assert.assertTrue(moviePage.isPageOpened(), title + " movie search page is not opened!");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(moviePage.readTitle(), title, "Invalid title!");
        softAssert.assertEquals(moviePage.readReleaseDate(), date, "Invalid release date!");
        softAssert.assertEquals(moviePage.readDirector(), director, "Invalid director!");

        softAssert.assertAll();
    }

    @Test
    @TestPriority(Priority.P3)
    public void testHoroscope() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickEntertainment();
        YahooEntertainmentPage entertainmentPage = new YahooEntertainmentPage(getDriver());
        Assert.assertTrue(entertainmentPage.isPageOpened(), "Entertainment page is not opened!");
        String dailyHoroscope = entertainmentPage.getHoroscopeMenu().readSelectedHoroscope();

        YahooLifePage lifePage = entertainmentPage.getHeaderMenu().openLifePage();
        Assert.assertTrue(lifePage.isPageOpened(), "Life page is not opened!");

        assertEquals(dailyHoroscope, lifePage.getHoroscopeMenu().readSelectedHoroscope(), "Mismatching Horoscopes!");
    }


    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/countries.xlsx", sheet = "Countries", dsUid = "TUID", dsArgs = "name, link, trendingNow")
    @TestPriority(Priority.P3)
    public void testCountrySwitch(String name, String link, String trendingNow) {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickProductService();
        YahooProductServicePage productServicePage = new YahooProductServicePage(getDriver());
        Assert.assertTrue(productServicePage.isPageOpened(), "Product and Service page is not opened!");

        productServicePage.clickChooseCountry();
        YahooInternationalPage internationalPage = new YahooInternationalPage(getDriver());
        Assert.assertTrue(internationalPage.isPageOpened(), "International page is not opened!");

        YahooCountryHomePage countryHomePage = internationalPage.selectCountry(name, link);
        Assert.assertTrue(countryHomePage.isPageOpened(), name + " homepage is not opened!");

        Assert.assertEquals(countryHomePage.getTrendingNow(), trendingNow, "Wrong language!");
    }

    @Test
    @TestPriority(Priority.P3)
    public void testCryptoInfo() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.clickFinance();
        YahooFinancePage financePage = new YahooFinancePage(getDriver());
        Assert.assertTrue(financePage.isPageOpened(), "Finance page is not opened!");

        financePage.clickCrypto();
        YahooCryptoPage cryptoPage = new YahooCryptoPage(getDriver());
        Assert.assertTrue(cryptoPage.isPageOpened(), "Crypto page is not opened!");

        YahooCryptoQuotePage cryptoQuotePage = cryptoPage.searchCrypto("DOGE-USD");
        Assert.assertTrue(cryptoQuotePage.isPageOpened(), "Crypto quote page is not opened!");

        Assert.assertEquals(cryptoQuotePage.readName(), "Dogecoin USD (DOGE-USD)", "Crypto name is wrong!");
        Assert.assertEquals(cryptoQuotePage.readDate(), "2013-12-15", "Crypto date is wrong!");
    }
}
