package ru.levelp.at.lesson0304;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;

public class CommonsIoExample {

    public static void main(String[] args) {
        try {
            var content = FileUtils.readFileToString(new File("testfiles/content.txt"), StandardCharsets.UTF_8);
            System.out.println(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
