package ru.levelp.at.trello.taf.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:env/${env}/api.properties",
    "system:properties",
    "system:env"
})
public interface ApiConfig extends Config {

    @Key("trello.api.url")
    String getApiUrl();

    @Key("trello.api.version")
    String getApiVersion();

    @Key("trello.api.key")
    String getApiKey();

    @Key("trello.api.token")
    String getApiToken();
}
