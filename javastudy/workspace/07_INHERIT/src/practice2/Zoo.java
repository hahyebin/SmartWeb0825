package practice2;

public class Zoo {
	
	private Animal[] animals;
	private int idx;
	
	public Zoo() {
		animals = new Animal[3];
	}
	public void addAnimal(Animal animal) {
		if(idx == animals.length) {
			System.out.println("FUll");
		}
		animals[idx++] = animal;	
	}	
	public void animalsInfo() {
		for(int i=0 ;i<idx; i++) {
	     animals[i].eat();
  	if(animals[i] instanceof Shark) {
		((Shark) animals[i]).swim();
	} else if(animals[i] instanceof Lion) {
		((Lion)animals[i]).run();
	}
		}
	}

}
