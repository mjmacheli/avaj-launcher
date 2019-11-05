package com.mmacheli.avaj;

import com.mmacheli.avaj.Application;
import com.mmacheli.avaj.Flyable;
import com.mmacheli.avaj.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch(weather){
			case "RAIN"	:
				this.coordinates.setHeight(this.coordinates.getHeight() - 5);
				break;
			case "FOG"	:
				this.coordinates.setHeight(this.coordinates.getHeight() - 3);
				break;
			case "SUN"	:
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
				this.coordinates.setHeight(this.coordinates.getHeight() + 4);
				break;
			case "SNOW"	:
				this.coordinates.setHeight(this.coordinates.getHeight() - 15);
				break;
		}
		aircraftMessage(weather);

		if (this.coordinates.getHeight() == 0) {
			Application.simulationWriter.println("Baloon#"
				+ this.name + "("+this.id+")landing."
			);

			weatherTower.unregister(this);

			Application.simulationWriter.println("Tower says: Baloon#"
				+ this.name + "("+this.id+")"
				+ "unregistered from weather tower."
			);
		}
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		
		Application.simulationWriter.println("Tower says: Baloon#"
			+ this.name + "(" + this.id + ")"
			+ "registered to weather tower."
		);
	}
}
