package lesson27.listener;

import java.util.ArrayList;
import java.util.List;

// наблюдатель
public class Agency {
    private ArrayList<Listener> listeners = new ArrayList<>();

    public void addListener(Listener listener) {
        listeners.add(listener);
    }
    public void deleteListener(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(String data){
        for (Listener listener: listeners){
            listener.publish(data);
        }
    }

    public void someChanges(String data){
        System.out.println("Изменения в объекте: " + data);
        notifyListeners(data);
    }

    public static void main(String[] args) {
        Agency agency = new Agency();

        Listener listener1 = new Listener() {
            @Override
            public void publish(String data) {
                System.out.println("listener1 получил " + data);
            }

//            @Override
//            public void someVoid() {
//
//            }
        };
        agency.addListener(listener1);
        Listener listener2 = new Listener() {
            @Override
            public void publish(String data) {
                System.out.println("listener2 получил " + data);
            }
        };
        agency.addListener(listener2);
        agency.someChanges("Изменения в agency");
    }
}



