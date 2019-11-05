package com.mmacheli.avaj;

import java.util.Random;

import com.mmacheli.avaj.Coordinates;

public class WeatherProvider {
	
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
	
	public WeatherProvider() {
		WeatherProvider.weatherProvider = this;
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}
	
	public String getCurrentWeather(Coordinates coordinates) {
		Random	random = new Random();

		int		weatherIndex = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() + random.nextInt(10 + weather.length) + 1) % weather.length;
		return weather[weatherIndex];
	}
}
