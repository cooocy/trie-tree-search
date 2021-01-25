package v3.graviti;

import v3.Associable;
import v3.Prefix;
import v3.TrieTree;

import java.util.List;

public class GravitiAssociator {

    private static volatile GravitiAssociator associator;

    private final TrieTree<Associable> tree;

    private GravitiAssociator() {
        tree = new TrieTree<>();
    }

    public void put(Associable associable) {
        tree.put(associable);
    }

    public List<Associable> collect(Prefix prefix) {
        return tree.collect(prefix, 10);
    }

    public static GravitiAssociator getInstance() {
        if (associator == null) {
            synchronized (GravitiAssociator.class) {
                if (associator == null) {
                    associator = new GravitiAssociator();
                }
            }
        }
        return associator;
    }

}
