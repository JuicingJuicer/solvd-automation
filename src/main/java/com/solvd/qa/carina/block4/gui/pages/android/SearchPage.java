package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {
    @FindBy(id = "com.google.android.settings.intelligence:id/open_search_view_edit_text")
    private ExtendedWebElement searchBar;

    @FindBy(xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout")
    private ExtendedWebElement result;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return searchBar.isElementPresent();
    }

    public void search(String text) {
        searchBar.click();
        searchBar.type(text);
        result.click();
    }
}
