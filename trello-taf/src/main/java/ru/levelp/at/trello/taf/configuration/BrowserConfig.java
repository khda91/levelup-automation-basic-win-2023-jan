package ru.levelp.at.trello.taf.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:browsers/${browserName}.properties",
    "system:properties",
    "system:env"
})
public interface BrowserConfig extends Config {

    @Key("browser.name")
    String getBrowserName();

    @Key("browser.wait.in.millis")
    Long getBrowserWait();
}
