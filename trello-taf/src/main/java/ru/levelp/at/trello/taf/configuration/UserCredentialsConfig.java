package ru.levelp.at.trello.taf.configuration;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({
    "classpath:env/${env}/user_credentials.properties",
    "system:properties",
    "system:env"
})
public interface UserCredentialsConfig extends Config {

    @Key("simple.trello.username")
    String getSimpleTrelloUsername();

    @Key("simple.trello.password")
    String getSimpleTrelloPassword();
}
