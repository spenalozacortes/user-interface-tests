package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class EnvironmentConfig {

    private static final ISettingsFile ENVIRONMENT = new JsonSettingsFile("environment.json");

    public static String getUrl() {
        return ENVIRONMENT.getValue("/url").toString();
    }
}
