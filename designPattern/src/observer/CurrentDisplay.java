package observer;

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/17 21:33 <br>
 */
public class CurrentDisplay implements Observer {
    private double temperature;
    private double humidity;
    private Observable observable;

    CurrentDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        WeatherData data = (WeatherData) o;
        this.temperature = data.temperature;
        this.humidity = data.humidity;
        display();
    }

    private void display() {
        System.out.println(new Date());
        System.out.println("temperature: " + temperature);
        System.out.println("humidity: " + humidity);
    }
}
