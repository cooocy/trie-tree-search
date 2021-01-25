package v2;

import java.util.Collections;
import java.util.Set;

public final class TrieTree {

    private static final Node ROOT = new Node();

    public static void put(String sentence) {
        sentence = format(sentence);
        if (!sentence.isBlank()) {
            Node cur = ROOT;
            for (int i = 0; i < sentence.length(); i++) {
                char ch = sentence.charAt(i);
                if (!cur.contains(ch)) {
                    cur.put(ch);
                }
                cur = cur.children.get(ch);
            }
            if (!cur.isSentence()) {
                cur.sentence = sentence;
            }
        }
    }

    public static Set<String> collect(String prefix) {
        prefix = format(prefix);
        Node cur = ROOT;
        char ch;
        for (int i = 0; i < prefix.length(); i++) {
            ch = prefix.charAt(i);
            if (!cur.contains(ch)) {
                return Collections.emptySet();
            }
            cur = cur.nextLevel(ch);
        }
        return cur.collect();
    }

    private static String format(String sentence) {
        return sentence.toLowerCase();
    }

}
