package com.dwolla.sagar.ApiKeyGen;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiKey {

    public ApiKey () throws Exception {

    }
    //This is the path we will store our key in a local file named Key.txt

    private final String path = new File("src/main/java/environment/Key.txt").getAbsolutePath();
    private String key = readFileAsString(path);

    public String getKey() {
        return key;
    }

    private static String readFileAsString(String fileName)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

}
