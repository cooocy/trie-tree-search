package v3;

/**
 * extends this class and then can be associated in TrieTree.
 * e.g:
 * ** [(value=x, frequency=0), (value=y, frequency=1), (value=z, frequency=2)]
 * ** sort:
 * ** [(value=z, frequency=2), (value=y, frequency=1), (value=x, frequency=0)]
 */
public abstract class Associable implements Comparable<Associable> {

    private static final int DEFAULT_FREQUENCY = 0;

    /**
     * value of this associable object. Can be a sentence, a word...
     */
    public final String value;

    /**
     * frequency of this associable object. The higher value has the higher priority.
     */
    public final int frequency;

    public Associable(String value, int frequency) {
        value = format(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("value can not be blank");
        }
        if (frequency < 0) {
            throw new IllegalArgumentException("frequency can not lt 0");
        }
        this.value = value;
        this.frequency = frequency;
    }

    public Associable(String value) {
        this(value, DEFAULT_FREQUENCY);
    }

    @Override
    public final int compareTo(Associable associable) {
        return associable.frequency - frequency;
    }

    public static String format(String value) {
        return value.toLowerCase();
    }

}