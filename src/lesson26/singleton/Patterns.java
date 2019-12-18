package lesson26.singleton;

public class Patterns {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.data = "Some data";

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.data); // Some data

        Singleton singleton3 = Singleton.getInstance();
        System.out.println(singleton3.data); // Some data
    }
}

