package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class EnvironmentConfig {

    static ISettingsFile environment = new JsonSettingsFile("environment.json");

    public static String getUrl() {
        return environment.getValue("/url").toString();
    }
}
