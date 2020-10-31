package io.ctdev;

import io.ctdev.BaseTest;
import io.ctdev.SystemConfig;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AppTest extends BaseTest {

    @DataProvider(name = "SearchProvider")
    public static Object[][] getDataFromDataProvider() {
        return new Object[][]{
                {SystemConfig.config.googleTitle(), SystemConfig.config.googleUrl()},
                {SystemConfig.config.instagramTitle(), SystemConfig.config.instagramUrl()},
                {SystemConfig.config.facebookTitle(), SystemConfig.config.facebookUrl()}
        };
    }

    @Test(dataProvider = "SearchProvider")
    public void testOpenUrlAndGetTitle(String expectedTitle, String url) {
        openUrl(url);

        String actualTitle = getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle), "Tab title is not equal");
    }
}