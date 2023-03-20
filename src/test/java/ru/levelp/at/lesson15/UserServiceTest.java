package ru.levelp.at.lesson15;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.levelp.at.lesson15.model.User;
import ru.levelp.at.lesson15.service.UserService;

import java.security.SecureRandom;
import java.util.List;

class UserServiceTest {

    @Test
        // через цикл
    void getUserByEmail() {
        final var faker = new Faker();
        final var service = new UserService();
        final var random = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            var user = new User(random.nextLong(), faker.internet().emailAddress(), faker.name().fullName());
            service.addUser(user);
        }

        final var email = faker.internet().emailAddress();
        var user = new User(random.nextLong(), email, faker.name().fullName());
        service.addUser(user);

        User expectedUser = null;

        List<User> users = service.getUsers();
        for (User u : users) {
            if (email.equals(u.getEmail())) {
                expectedUser = u;
                break;
            }
        }

        System.out.println("User id is " + expectedUser.getId());
    }

    @Test
        // через stream API
    void getUserByEmailStreams() {
        final var faker = new Faker();
        final var service = new UserService();
        final var random = new SecureRandom();

        for (int i = 0; i < 10; i++) {
            var user = new User(random.nextLong(), faker.internet().emailAddress(), faker.name().fullName());
            service.addUser(user);
        }

        final var email = faker.internet().emailAddress();
        var user = new User(random.nextLong(), email, faker.name().fullName());
        service.addUser(user);

        User expectedUser = service.getUsers().stream()
                                   .filter(u -> email.equals(u.getEmail()))
                                   .findFirst()
                                   .get();
        System.out.println("User id is " + expectedUser.getId());
    }
}
