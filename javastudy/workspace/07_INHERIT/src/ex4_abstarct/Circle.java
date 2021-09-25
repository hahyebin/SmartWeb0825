package ex4_abstarct;

public class Circle extends Shape{
	
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
