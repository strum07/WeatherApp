package com.dwolla.sagar.keymanagement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.exit;

public class ApiKey {

    private static final String PATH = new File("src/main/java/environment/Key.txt").getAbsolutePath();

    private ApiKey() {
    }

    public static String getApiKey() {
        String keyRead = null;
        try {
            keyRead = new String(Files.readAllBytes(Paths.get(PATH)));
        } catch (IOException e) {
            System.out.println("File not found. Please refer to documentation to set the key.");
            exit(4);
            e.printStackTrace();
        }
        return keyRead;
    }
}
