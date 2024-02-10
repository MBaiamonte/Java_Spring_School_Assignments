package com.matthewbaiamonte.zookeeper.classes;

public class Gorilla extends Mammal {
	
	public Gorilla() {
	}
	
	public int throwObject(int numOfThrows){
		int energyCost = 5 * numOfThrows;
		this.energyLevel-=energyCost;
		System.out.println("watch your heads, its throwing stuff again");
		return super.displayEnergy(); //tried putting it all in one line but was getting error for having the print statment with void return type. how to get it all on one line??
	}//end throw object
	
	public int eatBanana(int numConsumed) {
		int energyGained = 10*numConsumed;
		this.energyLevel+= energyGained;
		System.out.println("this beast is nothing but a steriotype eating all those bananas");
		return super.displayEnergy();
	}//end eat banana
	
	public int climb() {
		this.energyLevel-=10;
		System.out.println("see I was right! they can climb objects!");
		return super.displayEnergy();
	}//end climb
	
}//end class
