抽象了TrieTree的数据结构，可以方便地进行扩展。

使用Map代替数组，支持对所有字符集进行搜索。并使用优先队列实现了词频排序。

## Example
```java
public final class Dataset extends Associable {
    public Dataset(String name, int frequency) {
        super(name, frequency);
    }
}

public class Main {
    public static void main(String[] args){
        TrieTree<Dataset> tree = new TrieTree<>();;
        tree.put(new Dataset("Graviti-ds1", 10));
        tree.put(new Dataset("Graviti-ds2", 5));
        tree.collect(new Prefix("Graviti")).forEach(System.out::println);
    }
}
```