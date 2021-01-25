package v3;

import java.util.Collections;
import java.util.List;

/**
 * 前缀树
 * 参考文档
 * https://juejin.im/post/6844904022894198798
 * https://developer.aliyun.com/article/763904
 * <strong>字母会被统一格式化成小写</strong>
 */
public class TrieTree<T extends Associable> {

    private Node<T> root = new Node<>();

    private long size = 0;

    public void reset() {
        root = new Node<>();
        size = 0;
    }

    public void put(T t) {
        String value = t.value;
        Node<T> cur = root;
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (!cur.contains(ch)) {
                cur.put(ch);
            }
            cur = cur.children.get(ch);
        }
        if (!cur.isSentence()) {
            cur.associable = t;
            size++;
        }
    }

    /**
     * 获取所有符合指定前缀的句子
     */
    public List<T> collect(Prefix prefix) {
        return collect(prefix, Integer.MAX_VALUE);
    }

    public List<T> collect(Prefix prefix, int limit) {
        String value = prefix.value;
        Node<T> cur = root;
        char ch;
        for (int i = 0; i < value.length(); i++) {
            ch = value.charAt(i);
            if (!cur.contains(ch)) {
                return Collections.emptyList();
            }
            cur = cur.nextLevel(ch);
        }
        return cur.collect(limit);
    }

}
