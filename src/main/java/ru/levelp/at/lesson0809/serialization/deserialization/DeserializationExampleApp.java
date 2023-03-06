package ru.levelp.at.lesson0809.serialization.deserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExampleApp {

    public static void main(String[] args) {
        System.out.println("DeserializationExampleApp");
        try (FileInputStream fileInputStream = new FileInputStream("serdeser/temp.txt")) {
            ObjectInputStream ois = new ObjectInputStream(fileInputStream);
            Object o = ois.readObject();
            System.out.println(o);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
