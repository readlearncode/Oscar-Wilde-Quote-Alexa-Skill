package com.readlearncode.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class SynonymBank {

    public static List<String[]> synonym = new ArrayList<>();

    static {

        // women, female, girl, girls, wife, wives
        synonym.add(new String[]{"women", "female", "girl", "girls", "wife", "wives"});

        // man, men, boy, boys, husband, husbands
        synonym.add(new String[]{"man", "men", "boy", "boys", "husband", "husbands"});

    }

}