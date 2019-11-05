package com.mmacheli.avaj;

import com.mmacheli.avaj.Coordinates;

public class WeatherTower extends Tower {
	
	public String getWeather(Coordinates coordinates) {
		return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
	}
	
	void changeWeather() {
		conditionsChanged();
	}

	public void updateWeather(int iter) {
		int iterations = iter;
		
		if (iterations <= 0) {
			System.out.println("Error: - Simulations needs to run atleast once, provide a number greater than " + iterations);
			System.exit(1);
		} 
		while (iterations > 0) {
			this.changeWeather();
			iterations--;
		}
		System.out.println("Simulation successful");
	}
}
