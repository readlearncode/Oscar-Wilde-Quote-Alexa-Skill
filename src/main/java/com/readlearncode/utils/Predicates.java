package com.readlearncode.utils;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Predicates {

    private Predicates() {
    }

    public static Predicate<String> subject(String s) {
        Optional<String> subject = Optional.ofNullable(s);
        return quote -> subject.isPresent() && Search.forMatch(quote, Search.forSynonyms(subject.get()));
    }
}