package ru.levelp.at.trello.taf.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:env/${env}/web_ui.properties",
    "system:properties",
    "system:env"
})
public interface WebUiConfig extends Config {

    @Key("trello.app.url")
    String getTrelloApiUrl();
}
