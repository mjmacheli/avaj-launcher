package com.mmacheli.avaj;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

import com.mmacheli.avaj.Flyable;
import com.mmacheli.avaj.WeatherTower;
import com.mmacheli.avaj.ValidateFile;

public class Application {
	public static PrintWriter	simulationWriter;

	public static void main(String[] args) {
		File			scenarioFile;
		File			simulationFile;
		String			line;
		Scanner 		scannerInput;

		int				iterations		= 0;
		int				lineNumber		= 1;
		WeatherTower	weatherTower	= new WeatherTower();

		try {
			scenarioFile		= new File(args[0]);
			scannerInput		= new Scanner(scenarioFile);
			simulationFile		= new File("simulation.txt");
			simulationWriter	= new PrintWriter(simulationFile);
			if (scenarioFile.length() == 0) {
				throw new Exception("Scenario File empty!");
			}
			while(scannerInput.hasNextLine()) {
				line = scannerInput.nextLine();

				if ((lineNumber == 1) && (line.split(" ").length == 1)) {
					iterations = Integer.parseInt(line.split(" ")[0]);
				} else if ((lineNumber == 1) && (line.split(" ").length != 1)) {
					System.out.println("Error: Line 1 should only contain a single number");
					System.exit(1);
				} else {
					ValidateFile.aircraft(line, lineNumber).registerTower(weatherTower);
				}
				lineNumber++;
			}
			weatherTower.updateWeather(iterations);
			simulationWriter.close();
		} catch (NumberFormatException e) {
			System.out.println("Error converting argument to number : Line - " + lineNumber + " " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Error : File - " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No scenario file provided!!!");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
