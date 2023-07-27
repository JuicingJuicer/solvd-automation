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

        YahooWeatherPage weatherPage = homePage.openWeather();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(weatherPage.isPageOpened(), "Weather page is not opened!");
        softAssert.assertEquals(homeCity, weatherPage.readCity(), "Invalid city!");

        softAssert.assertAll();
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/YahooMovies.xlsx", sheet = "Movies", dsUid = "TUID", dsArgs = "search, link, title, date, director")
    @TestPriority(Priority.P3)
    public void testMovieSearch(String search, String link, String title, String date, String director) {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        YahooMovieSearchPage moviePage = homePage.searchMovie(search, link);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(moviePage.isPageOpened(), title + " movie search page is not opened!");
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

        YahooEntertainmentPage entertainmentPage = homePage.openEntertainment();
        Assert.assertTrue(entertainmentPage.isPageOpened(), "Entertainment page is not opened!");
        String dailyHoroscope = entertainmentPage.getHoroscopeMenu().readSelectedHoroscope();

        YahooLifePage lifePage = entertainmentPage.getHeaderMenu().openLifePage();
        Assert.assertTrue(lifePage.isPageOpened(), "Life page is not opened!");
        assertEquals(dailyHoroscope, lifePage.getHoroscopeMenu().readSelectedHoroscope(), "Mismatching Horoscopes!");
    }


    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "data_source/YahooCountries.xlsx", sheet = "Countries", dsUid = "TUID", dsArgs = "name, link, trendingNow")
    @TestPriority(Priority.P3)
    public void testCountrySwitch(String name, String link, String trendingNow) {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        YahooProductServicePage productServicePage = homePage.openProductService();
        Assert.assertTrue(productServicePage.isPageOpened(), "Product and Service page is not opened!");

        YahooInternationalPage internationalPage = productServicePage.openInternationalPage();
        Assert.assertTrue(internationalPage.isPageOpened(), "International page is not opened!");

        YahooCountryHomePage countryHomePage = internationalPage.selectCountry(name, link);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(countryHomePage.isPageOpened(), name + " homepage is not opened!");
        softAssert.assertEquals(countryHomePage.getTrendingNow(), trendingNow, "Wrong language!");

        softAssert.assertAll();
    }

    @Test
    @TestPriority(Priority.P3)
    public void testCryptoInfo() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        YahooFinancePage financePage = homePage.openFinance();
        Assert.assertTrue(financePage.isPageOpened(), "Finance page is not opened!");

        YahooCryptoPage cryptoPage = financePage.openCrypto();
        Assert.assertTrue(cryptoPage.isPageOpened(), "Crypto page is not opened!");

        YahooCryptoQuotePage cryptoQuotePage = cryptoPage.searchCrypto("DOGE-USD");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(cryptoQuotePage.isPageOpened(), "Crypto quote page is not opened!");
        softAssert.assertEquals(cryptoQuotePage.readName(), "Dogecoin USD (DOGE-USD)", "Crypto name is wrong!");
        softAssert.assertEquals(cryptoQuotePage.readDate(), "2013-12-15", "Crypto date is wrong!");

        softAssert.assertAll();
    }
}
