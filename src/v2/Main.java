package v2;

public class Main {

    public static void main(String[] args) {
        testTrie();
    }

    private static void testTrie() {
        TrieTree.put("女神生气怎么哄");
        TrieTree.put("女神说她要洗澡了");
        TrieTree.put("女神和舔狗");
        TrieTree.put("女神生了");

        TrieTree.collect("女神").forEach(System.out::println);
        System.out.println("|||||||||||||||||||||||");
        TrieTree.collect("女神生").forEach(System.out::println);
    }

}
