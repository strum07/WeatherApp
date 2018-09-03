package com.dwolla.sagar.ApiKeyGen;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.lang.System.exit;

public class ApiKey {

    private static ApiKey instance = null;
    private final String path = new File("src/main/java/environment/Key.txt").getAbsolutePath();
    private String key;

    {
        try {
            key = readFileAsString(path);
        } catch (Exception e) {
            System.out.println("Cannot find file in the location. Please refer to documentation to set the key.");
            exit(5);
        }
    }

    protected ApiKey() {
        // Exists only to stop instantiation. #SingletonPattern!
    }

    private static String readFileAsString(String fileName)
    {
        String keyRead = null;
        try {
            keyRead = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println("File not found. Please refer to documentation to set the key.");
            exit(4);
            e.printStackTrace();
        }
        return keyRead;
    }

    public static ApiKey getInstance() {
        if(instance == null) {
            instance = new ApiKey();
        }
        return instance;
    }

    public String getKey() {
        return key;
    }
}
