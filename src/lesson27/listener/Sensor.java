package lesson27.listener;

import java.util.ArrayList;

public class Sensor {
    int temp = 0;
    private ArrayList<Alarm> alarms = new ArrayList<>();

    public void addAlarm(Alarm alarm){
        alarms.add(alarm);
    }
    public void deleteAlarm(Alarm alarm){
        alarms.remove(alarm);
    }

    public void notifiAlarm(int data){
        for (Alarm alarm: alarms){
            alarm.tempChanfed(data);
        }
    }

    public static void main(String[] args) {
        Sensor sensor = new Sensor();

        Alarm green = new Alarm() {
            boolean work = false;
            @Override
            public void tempChanfed(int temp) {
                if (temp > 100 && !work ){
                    System.out.println("Green, temp = " + temp);
                    work = true;
                }
            }
        };
        sensor.addAlarm(green);

        Alarm yellow = new Alarm() {
            boolean work = false;
            @Override
            public void tempChanfed(int temp) {
                if (temp > 300 && !work ){
                    System.out.println("Yellow, temp = " + temp);
                    work = true;
                }
            }
        };
        sensor.addAlarm(yellow);

        Alarm red = new Alarm() {
            boolean work = false;
            @Override
            public void tempChanfed(int temp) {
                if (temp > 600 && !work ){
                    System.out.println("Red, temp = " + temp);
                    work = true;
                }
            }
        };
        sensor.addAlarm(red);
        while (true) {
            sensor.change();
        }
    }

    public void change(){
        temp += 50;
        notifiAlarm(temp);
    }


}

