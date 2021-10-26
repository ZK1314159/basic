package observer;

import java.util.Observable;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/17 21:30 <br>
 */
public class WeatherData extends Observable {
    double temperature;
    double humidity;

    void setWeatherData(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        setChanged();
        notifyObservers();
    }
}
