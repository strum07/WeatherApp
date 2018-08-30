package com.dwolla.sagar.ApiKeyGen;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FetchKey {
    private static String readFileAsString(String fileName)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }


    public static void main(String[] args) throws Exception
    {

        //String Path = "C:\\Users\\ss\\Desktop\\WeatherApp\\src\\main\\java\\com\\dwolla\\sagar\\env\\Key.txt";
        //String data = readFileAsString(Path);
        //System.out.println(data);
        //String basePath = new File("").getAbsolutePath();
        //System.out.println(basePath);

        String path = new File("src/main/java/environment/Key.txt").getAbsolutePath();

        System.out.println(path);

        String data = readFileAsString(path);

        System.out.println(data);
    }
}
