package com.dwolla.sagar.tokenizer;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FormatInput {
    public static final String DELIMITERS = " ,./;";

    private FormatInput() {
    }

    public static List<String> getFormattedInputList(final String rawInput) {
        List<String> tokens = getTokens(rawInput);
        List<String> formatInputList = new ArrayList<>();
        int lastIndex = tokens.size() - 1;
        if (tokens.size() > 1) {
            int numberOfCharLastIndex = tokens.get(lastIndex).length();
            //if country is entered
            if (numberOfCharLastIndex == 2) {
                formatInputList.add(concatTokens(tokens.subList(0, lastIndex)));
                formatInputList.add(tokens.get(lastIndex));
            } else {
                formatInputList.add(concatTokens(tokens.subList(0, tokens.size())));
            }
        } else {
            formatInputList.add(concatTokens(tokens.subList(0, tokens.size())));
        }
        return formatInputList;
    }

    private static List<String> getTokens(String str) {
        List<String> tokens = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(str, DELIMITERS);
        while (tokenizer.hasMoreElements()) {
            tokens.add(tokenizer.nextToken().toLowerCase());
        }
        return tokens;
    }

    private static String concatTokens(List<String> tokenList) {
        return String.join("", tokenList);
    }
}
