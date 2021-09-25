package ex5_interface;

public class Circle implements Shape{
	
	private int r;

	
	
	
	
	public Circle(int r) {
		super();
		this.r = r;
	}


	@Override
	public double getArea() {
		return r * r * Math.PI;
	}

	
	
}
