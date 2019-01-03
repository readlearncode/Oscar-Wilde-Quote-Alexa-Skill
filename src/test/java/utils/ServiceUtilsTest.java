package utils;

import com.readlearncode.utils.ServiceUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Source code github.com/readlearncode
 *
 * @author Alex Theedom www.readlearncode.com
 * @version 1.0
 */
class ServiceUtilsTest {

    @Test
    void shouldGenerateARandomQuote() {
        assertEquals(String.class, ServiceUtils.randomQuoteFromBank().getClass());
    }

    @Test
    void shouldReturnQuoteIfSubjectNotFound() {
        assertNotNull(ServiceUtils.findQuoteAbout("NONE EXISTENT SUBJECT"));
    }

    @Test
    @Disabled
        // Broken because the response is now random
    void shouldFindSpecificQuoteAboutWomen() {
        assertEquals(
                "All women become like their mothers. That is their tragedy. No man does. That's his.",
                ServiceUtils.searchQuote("women").get());
    }

    @Test
    void shouldFindAnyQuoteAboutWomen() {
        assertEquals(String.class, ServiceUtils.searchQuote("women").get().getClass());
    }

    @Test
    void shouldFindAnyQuoteAboutGirls() {
        assertEquals(String.class, ServiceUtils.searchQuote("girls").get().getClass());
    }

    @Test
    void shouldFindAnyQuoteAboutGirlsGivenSubjectIsWomen() {
        assertTrue(ServiceUtils.searchQuote("girls").get().contains("women"));
    }

    @Test
    void shouldFindAnyQuoteAboutHusbands() {
        assertEquals(String.class, ServiceUtils.searchQuote("husbands").get().getClass());
    }

    @Test
    void shouldIgnoreCase() {
        assertEquals(String.class, ServiceUtils.searchQuote("MeN").get().getClass());
    }

    @Test
    void shouldReturnQuoteIfSubjectIsNull() {
        assertNotNull(ServiceUtils.findQuoteAbout(null));
    }

}