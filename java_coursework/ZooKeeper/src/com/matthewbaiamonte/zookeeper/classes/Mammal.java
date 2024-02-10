package com.matthewbaiamonte.zookeeper.classes;

public class Mammal {
protected int energyLevel = 100;
	
	public Mammal() {
	}

	public int displayEnergy() {
		System.out.println("the energy level is: "+ this.energyLevel);
		return this.energyLevel;
	}


	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
		
}
