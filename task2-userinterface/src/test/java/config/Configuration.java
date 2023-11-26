package config;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class Configuration {

    static ISettingsFile environment = new JsonSettingsFile("config.json");

    public static String getUrl() {
        return environment.getValue("/url").toString();
    }
}
