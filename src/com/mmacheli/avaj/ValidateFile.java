package com.mmacheli.avaj;

import com.mmacheli.avaj.AircraftFactory;
import com.mmacheli.avaj.Flyable;

public class ValidateFile {
	public static Flyable aircraft(String line, int ln) {
		if (!line.isEmpty()) {
			if (line.split(" ").length == 5) {
				String[]	info		= line.split(" ");
				String		type		= info[0];
				String		name		= info[1];
				int			longitude	= Integer.parseInt(info[2]);
				int			latitude	= Integer.parseInt(info[3]);
				int			height		= Integer.parseInt(info[4]);
				Flyable		newAircraft	= AircraftFactory.newAircraft(type, name, longitude, latitude, height);

				if (newAircraft == null) {
					System.out.println("Error: Incorrect Aircraft type");
					System.exit(1);
				}
				return newAircraft;
			} else {
				System.out.println("Error: Incorrect Aircraft info format ");
				System.exit(1);
			}
		} else {
			System.out.println("Error: Empty line");
			System.exit(1);
		}
		return null;
	}
}
