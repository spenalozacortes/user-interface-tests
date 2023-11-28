package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataConfig {

    private static final ISettingsFile TEST_DATA = new JsonSettingsFile("testData.json");

    public static String getImagePath() {
        return TEST_DATA.getValue("/imagePath").toString();
    }
}
