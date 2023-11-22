package aquality.selenium.configuration;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;

public class Configuration {

    public static String getUrl() {
        ISettingsFile environment = new JsonSettingsFile("config.json");
        return environment.getValue("/url").toString();
    }
}
