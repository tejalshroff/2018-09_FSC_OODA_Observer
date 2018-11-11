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

/**
 * Simple observer for weather data
 *
 */
public interface Observer {
	
	/**
	 * Updates the temperature, humidity, and pressure of the observer as necessary
	 * 
	 * @param temp current temperature
	 * @param humidity current humidity level
	 * @param pressure current barometric pressure
	 */
	public void update(float temp, float humidity, float pressure);
}
