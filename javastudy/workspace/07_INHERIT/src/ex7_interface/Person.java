package ex7_interface;

public class Person {

	public void walk(Walkable pet) {
		System.out.println("Walking with " + ((Pet)pet).getName());
	}
}
