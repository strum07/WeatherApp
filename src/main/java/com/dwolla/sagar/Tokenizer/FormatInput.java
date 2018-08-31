package com.dwolla.sagar.Tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FormatInput {

    private String rawInput;
    List<String> tokenList = new ArrayList<>();
    
    //Constructor
    public FormatInput(String rawInput) {
        this.rawInput = rawInput;
        tokenList = getTokens(rawInput);
    }


    private List<String> getTokens(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, " ,./");
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken().toLowerCase());
        }
        return tokens;
    }


    private String concatTokens(List<String> tokenList) {

        String concat = new String();
        for (String aTokenList : tokenList) {
            concat = concat + aTokenList;
        }
        return concat;
    }

    public List<String> getFormattedInputList(){
        List<String> formatInputList = new ArrayList<>();
        int lastIndex = tokenList.size()-1;
        if(tokenList.size()>1){
            int numberOfCharLastIndex = tokenList.get(lastIndex).length();

            //if country is entered
            if(numberOfCharLastIndex == 2){
                formatInputList.add(concatTokens(tokenList.subList(0,tokenList.size()-1)));
                formatInputList.add(tokenList.get(lastIndex));

            }else{
                formatInputList.add(concatTokens(tokenList.subList(0,tokenList.size())));
            }
        }else{
            formatInputList.add(concatTokens(tokenList.subList(0,tokenList.size())));
        }
        return formatInputList;
    }
}
