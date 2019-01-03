package com.readlearncode.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Search {

    public static String[] forSynonyms(String subject) {
        return SynonymBank.synonym.stream()
                .filter(array -> Arrays.binarySearch(array, subject) > 0)
                .findFirst()
                .orElse(new String[]{subject});
    }

    public static boolean forMatch(String quote, String[] synonymArray){
      return  Stream.of(synonymArray).anyMatch(syn -> forMatch(quote, syn));
    }

    public static boolean forMatch(String quote, String expression) {
        Pattern pattern = Pattern.compile("(?i:\\b" + expression + "\\b)");
        Matcher matcher = pattern.matcher(quote);
        return matcher.find();
    }

}