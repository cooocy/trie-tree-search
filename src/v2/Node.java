package v2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class Node {

    /**
     * 当前节点的所有子节点, 某些子节点可能为null
     */
    protected final Map<Character, Node> children;

    /**
     * 如果当前节点是句子的结尾, 保存这个句子
     */
    protected String sentence;

    protected Node() {
        children = new ChildrenMap<>();
    }

    /**
     * 判断当前节点是不是一个句子
     */
    protected boolean isSentence() {
        return sentence != null;
    }

    /**
     * 将指定字符添加到当前节点的下一层(children)
     */
    protected void put(char ch) {
        if (!contains(ch)) {
            children.put(ch, new Node());
        }
    }

    /**
     * 判断当前节点的下一层中, 是否包含指定字符的节点
     */
    protected boolean contains(char ch) {
        return children.get(ch) != null;
    }

    /**
     * 获取当前节点的下一层中, 指定字符的节点
     */
    protected Node nextLevel(char ch) {
        return children.get(ch);
    }

    protected Set<String> collect() {
        HashSet<String> container = new HashSet<>();
        collect(container);
        return container;
    }

    private void collect(Set<String> container) {
        if (sentence != null) {
            container.add(sentence);
        }
        children.forEach((ch, node) -> children.get(ch).collect(container));
    }

}
