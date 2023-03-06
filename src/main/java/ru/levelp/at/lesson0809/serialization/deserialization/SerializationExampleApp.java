package ru.levelp.at.lesson0809.serialization.deserialization;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

public class SerializationExampleApp {

    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        var client = new Client(UUID.randomUUID().toString(), FAKER.name().firstName(), FAKER.name().lastName(),
            LocalDate.ofInstant(FAKER.date().birthday().toInstant(), ZoneId.systemDefault()),
            Long.valueOf(RandomStringUtils.randomNumeric(8)));

        System.out.println(client);

        try (FileOutputStream fileOutputStream = new FileOutputStream("serdeser/temp.txt")) {
            ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
            oos.writeObject(client);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
