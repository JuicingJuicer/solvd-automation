package com.solvd.qa.carina.block4.gui.pages.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class StoragePageBase extends AbstractPage {
    public StoragePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract double readStorageSizeUsed();

    public abstract double readStorageSizeTotal();

    public abstract double parseSize(String input);
}
