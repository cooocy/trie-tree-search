package basic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BasicHelper {

    /**
     * 在指定位置随机生成若干个单词。
     */
    public static void randomWords(int count, String fileName) {
        Random random = new Random();
        StringBuilder words = new StringBuilder();
        for (int i = 0; i < count; i++) {
            int length = random.nextInt(10) + 1;
            for (int i1 = 0; i1 < length; i1++) {
                int num = random.nextInt(26);
                words.append((char) (num + 97));
            }
            words.append("\n");
        }
        try {
            Files.writeString(Path.of(fileName), words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readWords(String file) {
        try {
            return Files.readAllLines(Path.of(file));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    public static void performance() {
        System.gc();
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();
        System.out.printf("total mem: %skb\n", total / 1024);
        System.out.printf("free mem: %skb\n", free / 1024);
        System.out.printf("used mem: %skb\n", (total - free) / 1024);
    }

}
