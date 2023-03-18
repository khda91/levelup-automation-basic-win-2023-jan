package ru.levelp.at.trello.taf.configuration.provider;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.aeonbits.owner.ConfigCache;
import ru.levelp.at.trello.taf.configuration.ApiConfig;
import ru.levelp.at.trello.taf.configuration.BrowserConfig;
import ru.levelp.at.trello.taf.configuration.UserCredentialsConfig;
import ru.levelp.at.trello.taf.configuration.WebUiConfig;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConfigProvider {

    public static UserCredentialsConfig userCredentialsConfig() {
        return ConfigCache.getOrCreate(UserCredentialsConfig.class);
    }

    public static WebUiConfig webUiConfig() {
        return ConfigCache.getOrCreate(WebUiConfig.class);
    }

    public static BrowserConfig browserConfig() {
        return ConfigCache.getOrCreate(BrowserConfig.class);
    }

    public static ApiConfig apiConfig() {
        return ConfigCache.getOrCreate(ApiConfig.class);
    }
}
