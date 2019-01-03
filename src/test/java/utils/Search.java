package utils;

import com.readlearncode.utils.QuoteBank;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
public class Search {
    static int x = 0;

    // 11 words with men in it

    @Test
    public void xxx() {

        Pattern pattern = Pattern.compile("(?i:\\bmen\\b)");
        QuoteBank.quotes.forEach(

                quote -> {
                    Matcher matcher = pattern.matcher(quote);
                    if (matcher.find()) x++;

                }

        );

        System.out.println(x);

    }


    @Test
    public void ccc() {

        Pattern pattern = Pattern.compile("\\bmen\\b");
        String ddd = "xxxxxx woman ddddd men ffffff women dddd erwermenerere mendddd men";
        Matcher matcher = pattern.matcher(ddd);
        matcher.find();
    }
}