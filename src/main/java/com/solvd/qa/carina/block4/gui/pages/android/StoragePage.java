package com.solvd.qa.carina.block4.gui.pages.android;

import com.solvd.qa.carina.block4.gui.pages.common.StoragePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = StoragePageBase.class)
public class StoragePage extends StoragePageBase {

    @FindBy(id = "com.android.settings:id/collapsing_toolbar")
    private ExtendedWebElement storageHeader;

    @FindBy(id = "com.android.settings:id/usage_summary")
    private ExtendedWebElement storageSizeUsed;

    @FindBy(id = "com.android.settings:id/total_summary")
    private ExtendedWebElement storageSizeTotal;

    public StoragePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(storageHeader);
    }

    @Override
    public double readStorageSizeUsed() {
        return parseSize(storageSizeUsed.getText());
    }

    @Override
    public double readStorageSizeTotal() {
        return parseSize(storageSizeTotal.getText());
    }

    @Override
    public double parseSize(String input) {
        String s = input;
        int endIndex = s.indexOf(" GB");
        String sub = s.substring(0, endIndex);
        return Double.parseDouble(sub);
    }
}
