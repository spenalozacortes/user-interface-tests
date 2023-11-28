package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class TestDataConfig {

    private static final ISettingsFile TEST_DATA = new JsonSettingsFile("testData.json");

    public static int getEmailLength() {
        return (int) TEST_DATA.getValue("/emailLength");
    }

    public static int getPasswordLength() {
        return (int) TEST_DATA.getValue("/passwordLength");
    }

    public static int getDomainLength() {
        return (int) TEST_DATA.getValue("/domainLength");
    }

    public static int getInterests() {
        return (int) TEST_DATA.getValue("/interests");
    }

    public static String getImagePath() {
        return TEST_DATA.getValue("/imagePath").toString();
    }

    public static String getTimer() {
        return TEST_DATA.getValue("/timer").toString();
    }
}
