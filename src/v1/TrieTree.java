package v1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class TrieTree {

    private static final Node ROOT = new Node();

    public static void put(String sentence) {
        Node cur = ROOT;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (!cur.contains(ch)) {
                cur.put(ch);
            }
            cur = cur.children[Node.indexOf(ch)];
        }
        if (!cur.isSentence()) {
            cur.sentence = sentence;
        }
    }

    public static Set<String> collect(String prefix) {
        Node cur = ROOT;
        char ch;
        for (int i = 0; i < prefix.length(); i++) {
            ch = prefix.charAt(i);
            if (!cur.contains(ch)) {
                return Collections.emptySet();
            }
            cur = cur.next(ch);
        }
        HashSet<String> container = new HashSet<>();
        cur.collect(container);
        return container;
    }

}
