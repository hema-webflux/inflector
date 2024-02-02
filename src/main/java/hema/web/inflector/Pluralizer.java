package hema.web.inflector;

import java.util.HashMap;
import java.util.Map;

final class Pluralizer implements WordInflector {

    private final Map<String, String> caches = new HashMap<>();

    @Override
    public String inflect(String word) {

        if (caches.containsKey(word)) {
            return caches.get(word);
        }

        String pluralWord = replace(word);

        caches.put(word, pluralWord);

        return pluralWord;
    }

    private String replace(String word) {

        boolean has = hasChars(word);

        String part = word.substring(0, word.length() - 1);

        if (word.endsWith("s") || word.endsWith("x") || word.endsWith("z") || word.endsWith("ch") || word.endsWith("sh")) {
            return word + "es";
        }

        if (word.endsWith("y") && has) {
            return part + "ies";
        }

        if (word.endsWith("f")) {
            return part + "ves";
        }

        if (word.endsWith("fe")) {
            return word.substring(0, word.length() - 2) + "ves";
        }

        if (word.endsWith("o") && has) {
            return word + "es";
        }

        return word + "s";
    }

    private boolean hasChars(String word) {
        String chars = "bcdfghjklmnpqrstvwxyzs";

        return chars.contains(String.valueOf(word.charAt(word.length() - 2)));
    }
}
