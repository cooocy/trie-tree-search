package v1;

import basic.BasicHelper;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // 生成words
        BasicHelper.randomWords(1000000, "words");

        // 初始化树
        BasicHelper.readWords("words").forEach(TrieTree::put);

        // 检索
        Instant begin = Instant.now();
        Set<String> gravitors = TrieTree.collect("huai");
        Instant end = Instant.now();

        // 结果
        long duration = ChronoUnit.MICROS.between(begin, end);
        System.out.printf("retrieve micros: %d\n", duration);
        System.out.printf("retrieve count: %d\n", gravitors.size());
        gravitors.forEach(System.out::println);

        // 内存
        BasicHelper.performance();
    }

}
