package practice1;

public class KoreanFighter extends Fighter{

	public KoreanFighter(String name) {
		super(name);
		
	}
	
	
	@Override
	public void attack(Fighter other) {
		if(Math.random()<0.1) {
			other.setEnergy(0);
		} else if(Math.random()<0.2) {
			other.setEnergy(getEnergy());
		} else 
			 other.setEnergy(other.getEnergy()-getPower());
		
		System.out.println(getName()+"의공격 > "+other.getName()+"의 남은에너지 : "+other.getEnergy());
	}


	
	
	
}
