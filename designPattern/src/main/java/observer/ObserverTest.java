package main.java.observer;

/**
 * Description：<br>
 * <br>
 * CreateDate：2020/7/21 21:08 <br>
 */
public class ObserverTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentDisplay currentDisplay = new CurrentDisplay(weatherData);
        weatherData.setWeatherData(36.5, 80);
    }
}
