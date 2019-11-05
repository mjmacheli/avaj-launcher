package com.mmacheli.avaj;

import com.mmacheli.avaj.Application;
import com.mmacheli.avaj.Flyable;
import com.mmacheli.avaj.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = this.weatherTower.getWeather(this.coordinates);
		switch(weather){
			case "RAIN"	:
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
				break;
			case "FOG"	:
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
				break;
			case "SUN"	:
				this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
				this.coordinates.setHeight(this.coordinates.getHeight() + 2);
				break;
			case "SNOW"	:
				this.coordinates.setHeight(this.coordinates.getHeight() - 12);
				break;
		}
		aircraftMessage(weather);

		if (this.coordinates.getHeight() == 0) {
			Application.simulationWriter.println("Helicopter#"
				+ this.name + "("+this.id+") landing."
			);

			weatherTower.unregister(this);

			Application.simulationWriter.println("Tower says: Helicopter#"
				+ this.name + " ("+this.id+") "
				+ "unregistered from weather tower."
			);
		}

	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		
		Application.simulationWriter.println("Tower says: Helicopter#"
			+ this.name + " (" + this.id + ") "
			+ "registered to weather tower."
		);
	}

}
