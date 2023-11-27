package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataConfig {

    static ISettingsFile testData = new JsonSettingsFile("testData.json");

    public static ISettingsFile getData() {
        return testData;
    }
}
