package ex3_has_a_without_extends;

public class Soldier {
	
	private Gun gun;
	
	
	public Soldier() {
		gun = new Gun();
	}
	
	public Gun getGun() {
		return gun;
	}

	public void setGun(Gun gun) {
		this.gun = gun;
	}

	public void shoot() {
		gun.shoot();
	}
	
	public void walk() {
		System.out.println("walk!");
	}

}
