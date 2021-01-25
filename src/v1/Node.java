package v1;

import java.util.Set;

public final class Node {

    /**
     * 小写字母和空格
     */
    private static final int ALPHABET_SIZE = 27;

    private static final char SPACE = ' ';

    /**
     * 当前节点的27个子节点, 可能某些节点为null
     */
    final Node[] children;

    /**
     * 如果当前节点是句子的结尾, 保存这个句子
     */
    String sentence;

    Node() {
        children = new Node[ALPHABET_SIZE];
    }

    /**
     * 判断当前节点是不是一个句子
     */
    boolean isSentence() {
        return sentence != null;
    }

    /**
     * 判断当前节点的下一层中, 是否包含指定字符的节点
     */
    boolean contains(char ch) {
        return children[indexOf(ch)] != null;
    }

    void put(char ch) {
        if (!contains(ch)) {
            children[indexOf(ch)] = new Node();
        }
    }

    /**
     * 获取当前节点的下一层中, 指定字符的节点
     */
    Node next(char ch) {
        return children[indexOf(ch)];
    }

    void collect(Set<String> container) {
        if (sentence != null) {
            container.add(sentence);
        }
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (children[i] != null) {
                children[i].collect(container);
            }
        }
    }

    public static int indexOf(char ch) {
        return ch == SPACE ? 26 : ch - 'a';
    }

}
