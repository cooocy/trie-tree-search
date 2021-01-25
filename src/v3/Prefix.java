package v3;

public class Prefix {

    public final String value;

    public Prefix(String value) {
        value = Associable.format(value);
        if (value.isBlank()) {
            throw new IllegalArgumentException("value can not be blank");
        }
        this.value = value;
    }

}
