package v3.graviti;

import v3.Prefix;

public class Main {

    public static void main(String[] args) {
        GravitiAssociator associator = GravitiAssociator.getInstance();
        associator.put(new Dataset("Graviti-ds1", 10));
        associator.put(new Dataset("Graviti-ds2", 5));
        associator.put(new Engineer("Graviti-A", 50));
        associator.put(new Engineer("Graviti-B", 100));
        associator.put(new Engineer("Graviti-C", 99));
        associator.put(new Engineer("Graviti-D", 45));
        associator.put(new Engineer("Graviti-E", 60));
        associator.put(new Engineer("Graviti-F", 55));

        associator.collect(new Prefix("Graviti")).forEach(System.out::println);
    }

}
