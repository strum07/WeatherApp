package com.dwolla.sagar.ApiKeyGen;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiKey {

    //This is the path we will store our key in a local file named Key.txt

    private static ApiKey instance = null;

    private final String path = new File("src/main/java/environment/Key.txt").getAbsolutePath();
    private String key = readFileAsString(path);

    protected ApiKey() throws Exception {
        // Exists only to defeat instantiation. #SingletonPattern!
    }

    public static ApiKey getInstance() throws Exception {
        if(instance == null) {
            instance = new ApiKey();
        }
        return instance;
    }

    public String getKey() {
        return key;
    }

    private static String readFileAsString(String fileName)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
