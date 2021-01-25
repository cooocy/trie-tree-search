package v3;

import java.util.*;

public final class Node<T extends Associable> {

    /**
     * 当前节点的所有子节点, 某些子节点可能为null
     */
    protected final Map<Character, Node<T>> children;

    /**
     * 如果当前节点是句子的结尾, 保存这个句子
     */
    protected T associable;

    protected Node() {
        children = new HashMap<>();
    }

    /**
     * 判断当前节点是不是一个句子
     */
    protected boolean isSentence() {
        return associable != null;
    }

    /**
     * 获取当前节点的句子
     */
    protected Optional<T> getSentence() {
        return Optional.ofNullable(associable);
    }

    /**
     * 将指定字符添加到当前节点的下一层(children)
     */
    protected void put(char ch) {
        if (!contains(ch)) {
            children.put(ch, new Node<>());
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
    protected Node<T> nextLevel(char ch) {
        return children.get(ch);
    }

    /**
     * 收集当前节点下的所有句子, 如果当前节点也是句子, 加入
     * 如果container.size() = limit, 停止收集
     */
    protected List<T> collect(int limit) {
        PriorityQueue<T> priorityQueue = new PriorityQueue<>();
        collect(priorityQueue);
        int min = Math.min(priorityQueue.size(), limit);
        List<T> topSentences = new ArrayList<>(min);
        for (int i = 0; i < min; i++) topSentences.add(priorityQueue.poll());
        return topSentences;
    }

    private void collect(PriorityQueue<T> priorityQueue) {
        if (associable != null) {
            priorityQueue.add(associable);
        }
        children.forEach((ch, node) -> children.get(ch).collect(priorityQueue));
    }

}
