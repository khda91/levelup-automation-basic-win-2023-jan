package ru.levelp.at.properties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Properties;

class PropertiesTest {

    private Properties properties;

    @BeforeEach
    void setUp() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream("/ru/levelp/at/properties/user.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void loginUser() {
        var username = properties.getProperty("user.name");
        var password = properties.getProperty("user.password");
        login(username, password);
    }

    private void login(final String username, final String password) {
        System.out.println(String.format("User '%s' login with password '%s'", username, password));
    }
}
