package lesson26.singleton;

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.data = "Some data";

        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton2.data); // Some data

        Singleton singleton3 = Singleton.getInstance();
        System.out.println(singleton3.data); // Some data
    }
}

// ленивая (отложенная) инициализация
class Singleton {
    public String data;
    private static Singleton instance;

    // закрываем возможность создания объекта вне класса
    private Singleton() {}

    public static Singleton getInstance(){
        if (instance == null) { // проверка был ли создан объект
            // создание объекта (если он не был создан ранее)
            instance = new Singleton();
        }
        return instance;
    }
}

// thread - safe Singleton
class Singleton2 {
    private static Singleton2 instance;

    // закрываем возможность создания объекта вне класса
    private Singleton2() {}

    public static synchronized Singleton2 getInstance(){
        if (instance == null) { // проверка был ли создан объект
            // создание объекта (если он не был создан ранее)
            instance = new Singleton2();
        }
        return instance;
    }
}

class Singleton3 {
    private static volatile Singleton3 instance;

    private Singleton3() {}

    public static Singleton3 getInstance(){
        Singleton3 local = instance;
        if (local == null) {
            synchronized (Singleton3.class){
                local = instance;
                if (local == null) {
                    instance = local = new Singleton3();
                }
            }
        }
        return local;
    }
}

class Singleton4 {
    public static class SingletonInst{
        public static final Singleton4 SINGLETON_INSTANCE = new Singleton4();
    }
    private Singleton4() {}

    public static Singleton4 getInstance(){
        return SingletonInst.SINGLETON_INSTANCE;
    }
}


