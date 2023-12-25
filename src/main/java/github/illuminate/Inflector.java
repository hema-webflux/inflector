package github.illuminate;

import github.illuminate.contacts.WordInflector;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public final class Inflector {

    private final WordInflector pluralizer;

    private final Map<String, Map<String, String>> snakeCache = new HashMap<>();

    public Inflector(WordInflector pluralizer) {
        this.pluralizer = pluralizer;
    }

    /**
     * Get the plural form of an English word.
     */
    public String plural(String value) {

        String[] words = split(value);

        if (words.length == 0) {
            return value;
        }

        int lastIndex = words.length - 1;

        words[lastIndex] = pluralizer.inflect(words[lastIndex]);

        return String.join("", words);
    }

    private String[] split(String value) {

        Matcher matcher = Pattern.compile("(.)(?=[A-Z])").matcher(value);

        return matcher.replaceAll("$1,").split(",");
    }

    /**
     * Convert a string to snake case.
     */
    public String snake(String value, String delimiter) {

        String key = value;

        if (snakeCache.containsKey(key)) {

            Map<String, String> word = snakeCache.get(key);

            if (word.containsKey(delimiter)) {
                return word.get(delimiter);
            }
        }

        if (!value.equals(value.toLowerCase())) {
            value = value.replaceAll("\\s+", "")
                    .replaceAll("(.)(?=[A-Z])", "$1_")
                    .toLowerCase();
        }

        Map<String, String> parseBeen = new HashMap<>();
        parseBeen.put(delimiter, value);

        snakeCache.put(key, parseBeen);

        return value;
    }

}
