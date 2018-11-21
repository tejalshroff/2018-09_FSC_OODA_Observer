package HW10.edu.fsu.csc7400.observer.weather;

public class HeatIndexDisplay implements Observer, DisplayElement {

    /**
     * Constructor with weather data
     *
     * @param weatherData the weather data for initialization
     * @precondition weatherData != null
     * @postcondition this will be registered as an observer to weatherData
     */
    public HeatIndexDisplay(WeatherData weatherData) {
        assert (weatherData != null);
        weatherData.registerObserver(this);

    }

    /**
     * Displays the data
     */
    @Override
    public void display() {
        System.out.println("Heat Index = " + heatIndex);
    }

    /**
     * Updates the display with new data
     *
     * @param temp     current temperature
     * @param humidity current humidity level
     * @param pressure current barometric pressure
     */
    @Override
    public void update(float temp, float humidity, float pressure) {
        t = temp;
        rh = humidity;
        //calculate heat index
        heatIndex = (float) (
                (16.923 + (0.185212 * t)) +
                        (5.37941 * rh) -
                        (0.100254 * t * rh) +
                        (0.00941695 * (t * t)) +
                        (0.00728898 * (rh * rh)) +
                        (0.000345372 * (t * t * rh)) -
                        (0.000814971 * (t * rh * rh)) +
                        (0.0000102102 * (t * t * rh * rh)) -
                        (0.000038646 * (t * t * t)) +
                        (0.0000291583 * (rh * rh * rh)) +
                        (0.00000142721 * (t * t * t * rh)) +
                        (0.000000197483 * (t * rh * rh * rh)) -
                        (0.0000000218429 * (t * t * t * rh * rh)) +
                        (0.000000000843296 * (t * t * rh * rh * rh)) -
                        (0.0000000000481975 * (t * t * t * rh * rh * rh)));

        display();

    }

    //Variable Declaration
    private float t;
    private float rh;
    private float heatIndex;
}
