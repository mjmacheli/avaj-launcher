package com.mmacheli.avaj;

import com.mmacheli.avaj.WeatherTower;
import com.mmacheli.avaj.Application;

import java.util.HashMap;

public class Aircraft {

	protected long id;
	protected String name;
	private static long idCounter;
	protected Coordinates coordinates;


	private HashMap <String, String> weatherBaloon = new HashMap<String, String>();
	private HashMap <String, String> weatherJetPlane = new HashMap<String, String>();
	private HashMap <String, String> weatherHelicopter = new HashMap<String, String>();

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();

		weatherBaloon.put("RAIN", "Let it rain!!!");
		weatherBaloon.put("FOG", "Blind as a bat!");
		weatherBaloon.put("SUN", "Too hot!!!");
		weatherBaloon.put("SNOW", "It is freezing outchea!!! ");

		weatherHelicopter.put("RAIN", "Wash away my sins lord!");
		weatherHelicopter.put("FOG", "I can't see a thing!");
		weatherHelicopter.put("SUN", "The hot is too heat!");
		weatherHelicopter.put("SNOW", "Is that  oulaf down there?");

		weatherJetPlane.put("RAIN", "Rain rain!");
		weatherJetPlane.put("FOG", "Its misty!");
		weatherJetPlane.put("SUN", "Clear sunny skies!");
		weatherJetPlane.put("SNOW", "Too cold to fly!");
	}

private long nextId() {

		Aircraft.idCounter++;

		return (Aircraft.idCounter);
	}

	// Aircraft logging messages
	public void aircraftMessage(String weather) {
		if (this.getClass().getSimpleName().equals("Baloon")) {
			Application.simulationWriter.println(this.getClass().getSimpleName()
			+"#" + this.name + " (" + this.id + "): "
			+ weatherBaloon.get(weather));
		} else if (this.getClass().getSimpleName().equals("Helicopter")) {
			Application.simulationWriter.println(this.getClass().getSimpleName()
				+ "#" + this.name + " (" + this.id + "): "
				+ weatherHelicopter.get(weather));
		} else if (this.getClass().getSimpleName().equals("JetPlane")) {
			Application.simulationWriter.println(this.getClass().getSimpleName()
				+ "#" + this.name + " (" + this.id + "): "
				+ weatherJetPlane.get(weather));
		}
	}

	
}
