package com.mmacheli.avaj;

import com.mmacheli.avaj.WeatherTower;

public interface Flyable {
	
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
}
