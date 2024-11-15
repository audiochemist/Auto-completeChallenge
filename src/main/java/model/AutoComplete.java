package model;

import java.util.*;

public class AutoComplete {

    private final NavigableSet<String> WORDS;

    public AutoComplete() {
        WORDS = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        WORDS.add("Pandora");
        WORDS.add("Pinterest");
        WORDS.add("Paypal");
        WORDS.add("Pg&e");
        WORDS.add("Project free tv");
        WORDS.add("Priceline");
        WORDS.add("Press democrat");
        WORDS.add("Progressive");
        WORDS.add("Project runway");
        WORDS.add("Proactive");
        WORDS.add("Programming");
        WORDS.add("Progeria");
        WORDS.add("Progesterone");
        WORDS.add("Progenex");
        WORDS.add("Procurable");
        WORDS.add("Processor");
        WORDS.add("Proud");
        WORDS.add("Print");
        WORDS.add("Prank");
        WORDS.add("Bowl");
        WORDS.add("Owl");
        WORDS.add("River");
        WORDS.add("Phone");
        WORDS.add("Kayak");
        WORDS.add("Stamps");
        WORDS.add("Reprobe");
    }

    public List<String> getAutoCompleteSuggestions(String inputPrefix) {
        if (inputPrefix == null || inputPrefix.isEmpty()) {
            return Collections.emptyList();
        }

        final String prefix = inputPrefix.toLowerCase();

        // Get a view of the set that starts with the given prefix
        SortedSet<String> subSet = WORDS.subSet(prefix, prefix + Character.MAX_VALUE);

        List<String> suggestions = new ArrayList<>(subSet);
        return suggestions.size() > 4 ? suggestions.subList(0, 4) : suggestions;
    }
}