package model;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AutoCompleteTest {


    @Test
    void getAutoCompleteSuggestions() {
        AutoComplete autoComplete = new AutoComplete();
        List<String> suggestions = autoComplete.getAutoCompleteSuggestions("Pro");

        String[] expectedOrder = {"Proactive", "Processor", "Procurable", "Progenex"};
        assertArrayEquals(expectedOrder, suggestions.toArray());

        assertFalse(suggestions.contains("Programming"));
        assertTrue(suggestions.size() <= 4);
    }


    @Test
    void returnsUpToFourSuggestions() {
        AutoComplete autoComplete = new AutoComplete();
        List<String> suggestions = autoComplete.getAutoCompleteSuggestions("P");
        assertEquals(4, suggestions.size());
    }

    @Test
    void returnsSuggestionsInAlphabeticalOrder() {
        AutoComplete autoComplete = new AutoComplete();
        List<String> suggestions = autoComplete.getAutoCompleteSuggestions("Pro");
        String[] expectedOrder = {"Proactive", "Processor", "Procurable", "Progenex"};
        assertArrayEquals(expectedOrder, suggestions.toArray());
    }


    @Test
    void returnsEmptyListForNonExistentPrefix() {
        AutoComplete autoComplete = new AutoComplete();
        List<String> suggestions = autoComplete.getAutoCompleteSuggestions("Xyz");
        assertTrue(suggestions.isEmpty());
    }

    @Test
    void returnsAllMatchingWordsIfLessThanFour() {
        AutoComplete autoComplete = new AutoComplete();
        List<String> suggestions = autoComplete.getAutoCompleteSuggestions("Kay");
        assertEquals(1, suggestions.size());
        assertTrue(suggestions.contains("Kayak"));
    }

    @Test
    void handlesEmptyPrefix() {
        AutoComplete autoComplete = new AutoComplete();
        List<String> suggestions = autoComplete.getAutoCompleteSuggestions("");
        assertEquals(0, suggestions.size());
    }

    @Test
    void handlesCaseInsensitivePrefix() {
        AutoComplete autoComplete = new AutoComplete();
        List<String> suggestions1 = autoComplete.getAutoCompleteSuggestions("PrO");
        List<String> suggestions2 = autoComplete.getAutoCompleteSuggestions("pRo");
        assertEquals(suggestions1, suggestions2);
    }
}