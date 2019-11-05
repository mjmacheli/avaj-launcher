package com.mmacheli.avaj;

import java.util.ArrayList;
import java.util.List;

import com.mmacheli.avaj.Flyable;


public class Tower {
	
	private List<Flyable> observers = new ArrayList<Flyable>();
	
	public void register(Flyable flyable) {
		this.observers.add(flyable);
	}
	
	public void unregister(Flyable flyable) {
		this.observers.remove(flyable);
	}
	
	protected void conditionsChanged() {
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).updateConditions();
		}
	}
}
