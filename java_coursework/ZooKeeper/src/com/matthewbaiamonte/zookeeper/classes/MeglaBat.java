package com.matthewbaiamonte.zookeeper.classes;

public class MeglaBat extends Mammal {

	public MeglaBat() {
		super.setEnergyLevel(300);
	}//end constructor
	
	public int fly(int numOfFlights) {
		int timesSeenFlying=numOfFlights*50;
		this.energyLevel-=timesSeenFlying;
		System.out.println("mmm Problay should have clipped its wings while we had the chance.. oh well how far away could it fly anyways..");
		return super.displayEnergy();
	}//end fly
	
	public int eatHumans(int numConsumed) {
		int numPeopleConsumed=numConsumed*25;
		this.energyLevel+=numPeopleConsumed;
		System.out.println("aww geez... better hyde yo kids, its eating people again... do you think we could be held liable? ");
		return super.displayEnergy();
	}//end eat people
	
	public int attackTown(int numOfTowns) {
		int townsAttacked=numOfTowns*100;
		this.energyLevel-=townsAttacked;
		System.out.println("yeahhh... were definialy gunna be held liable for that... how many towns has it visited at this point again? ");
		return super.displayEnergy();
	}//end attack town
		
	
}
