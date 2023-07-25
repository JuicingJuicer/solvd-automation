package com.solvd.qa.carina.block4;

import com.solvd.qa.carina.block4.gui.pages.desktop.*;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;

public class YahooTest implements IAbstractTest {

    @DataProvider(name = "movieDetails")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {R.TESTDATA.get("barbie.search"), R.TESTDATA.get("barbie.title"), R.TESTDATA.get("barbie.date"), R.TESTDATA.get("barbie.director")},
                        {R.TESTDATA.get("oppenheimer.search"), R.TESTDATA.get("oppenheimer.title"), R.TESTDATA.get("oppenheimer.date"), R.TESTDATA.get("oppenheimer.director")},
                        {R.TESTDATA.get("sof.search"), R.TESTDATA.get("sof.title"), R.TESTDATA.get("sof.date"), R.TESTDATA.get("sof.director")}
                };
    }

    @Test
    @TestPriority(Priority.P3)
    public void testCityWeather() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        String homeCity = homePage.getWeatherCity();

        YahooWeatherPage weatherPage = homePage.openWeather();
        assertEquals(homeCity, weatherPage.readCity(), "Invalid city!");
    }

    @Test(dataProvider = "movieDetails")
    @TestPriority(Priority.P3)
    public void testMovieSearch(String search, String title, String date, String director) {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        SoftAssert softAssert = new SoftAssert();
        YahooMovieSearchPage moviePage = homePage.searchMovie(search);
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
        Assert.assertTrue(lifePage.isPageOpened(), "Life page is not opened.");
        assertEquals(dailyHoroscope, lifePage.getHoroscopeMenu().readSelectedHoroscope(), "Mismatching Horoscopes!");
    }

    @Test
    @TestPriority(Priority.P3)
    public void testCountrySwitch() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        YahooProductServicePage productServicePage = homePage.openProductService();
        Assert.assertTrue(productServicePage.isPageOpened(), "Product and Service page is not opened!");

        YahooInternationalPage internationalPage = productServicePage.openInternationalPage();
        Assert.assertTrue(internationalPage.isPageOpened(), "International page is not opened!");

        YahooFranceHomePage franceHomePage = internationalPage.openFrancePage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(franceHomePage.isPageOpened(), "France homepage is not opened!");
        softAssert.assertEquals(franceHomePage.getTrendingNowInFrench(), "Tendances du jour", "Wrong language!");

        softAssert.assertAll();
    }

    @Test
    @TestPriority(Priority.P3)
    public void testCryptoInfo() {
        YahooHomePage homePage = new YahooHomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");

        YahooFinancePage financePage = homePage.openFinance();
        Assert.assertTrue(financePage.isPageOpened(), "Finance page is not opened");

        YahooCryptoPage cryptoPage = financePage.openCrypto();
        Assert.assertTrue(cryptoPage.isPageOpened(), "Crypto page is not opened");

        YahooCryptoQuotePage cryptoQuotePage = cryptoPage.searchCrypto("DOGE-USD");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(cryptoQuotePage.readName(), "Dogecoin USD (DOGE-USD)", "Crypto name is wrong!");
        softAssert.assertEquals(cryptoQuotePage.readDate(), "2013-12-15", "Crypto date is wrong!");

        softAssert.assertAll();
    }
}
