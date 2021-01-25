package v3.graviti;

import v3.Associable;

public final class Dataset extends Associable {

    public Dataset(String name, int frequency) {
        super(name, frequency);
    }

    @Override
    public String toString() {
        return "Dataset{" +
                "name='" + value + '\'' +
                ", frequency=" + frequency +
                '}';
    }

}
