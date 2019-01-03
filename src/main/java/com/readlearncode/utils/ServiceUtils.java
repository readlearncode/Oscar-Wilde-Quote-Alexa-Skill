package com.readlearncode.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class ServiceUtils {

    public static String randomQuoteFromBank() {
        int max = QuoteBank.quotes.size();
        int min = 0;
        int element = (int) (Math.random() * ((max - min))) + min;
        return QuoteBank.quotes.get(element);
    }

    /**
     * Selects a random quote from the given List.
     *
     * @param quotes a List of quotes
     * @return Optional<String> of the quote found or an empty optional
     */
    public static Optional<String> randomQuoteFrom(List<String> quotes) {
        int min = 0;
        int max;
        if ((max = quotes.size()) == 0) {
            return Optional.empty();
        }
        int element = (int) (Math.random() * ((max - min))) + min;
        return Optional.ofNullable(quotes.get(element));
    }

    public static String findQuoteAbout(String subject) {
        return searchQuote(subject)
                .orElseGet(ServiceUtils::randomQuoteFromBank);
    }

    /**
     * Iterates over a List of quotes and returns a random quote from those containing the subject
     *
     * @param subject the String value to search for in the List of quotes
     * @return Optional<String> of a quote
     */
    public static Optional<String> searchQuote(String subject) {

        List<String> quotes = QuoteBank.quotes
                .stream()
                .filter(Predicates.subject(subject))
                .collect(Collectors.toList());

        return randomQuoteFrom(quotes);
    }

}