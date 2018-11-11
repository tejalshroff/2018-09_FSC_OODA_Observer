/**
 * Class: Object-Oriented Design and Analysis
 * Professor: Orlando Montalvo
 * Assignment: HW 10
 * 
 * Date: 2018-11-11
 * 
 * Code taken from HeadFirst Object-Oriented Design Patterns sample
 */
package HW10.edu.fsu.csc7400.observer.weather;

import java.util.*;

/**
 * WeatherData collects readings from sensors and then broadcasts the values to observers
 *
 */
public class WeatherData implements Subject {
	
	/**
	 * Default constructor
	 */
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	/**
	 * Registers an observer
	 * 
	 * @param o the new observer
	 * 
	 * @precondition o != null
	 */
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	/**
	 * Removes a registered observer
	 * 
	 * @param o observer to remove
	 * 
	 * @precondition o != null
	 */
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	/**
	 * Notifies all registered observers of weather changes
	 */
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	/**
	 * Does whatever it needs to do when a sensor sends a change
	 */
	public void measurementsChanged() {
		notifyObservers();
	}
	
	/**
	 * Sets the weather values from the sensors.
	 * 
	 * @param temperature current temperature
	 * @param humidity current humidity level
	 * @param pressure current barometric pressure
	 */
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}
	
	/**
	 * Returns the current temperature
	 */
	public float getTemperature() {
		return temperature;
	}
	
	/**
	 * Returns the current humidity level
	 */
	public float getHumidity() {
		return humidity;
	}
	
	/**
	 * Returns the current barometric pressure
	 */
	public float getPressure() {
		return pressure;
	}

	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
}
