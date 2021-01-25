package v3.graviti;

import v3.Associable;

public class Engineer extends Associable {

    public Engineer(String name, int frequency) {
        super(name, frequency);
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "name='" + value + '\'' +
                ", frequency=" + frequency +
                '}';
    }

}
