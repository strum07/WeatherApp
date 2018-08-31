package com.dwolla.sagar;

import com.dwolla.sagar.Tokenizer.FormatInput;

import java.util.List;

public class delete {

    public static void main(String[] args) {


        FormatInput demo = new FormatInput("Chicago USA");

        List<String> myList = demo.getFormattedInput();

        for(int i=0;i<myList.size();i++){

            System.out.println(myList.get(i));
        }
    }
}
