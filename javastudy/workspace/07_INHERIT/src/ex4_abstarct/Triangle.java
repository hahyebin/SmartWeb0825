package ex4_abstarct;

public class Triangle extends Shape {
	
	private int height;
	private int width;
	
	
	
	public Triangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}



	@Override
	public double getArea() {
		return height*width*0.5;
	}
	
	
}
