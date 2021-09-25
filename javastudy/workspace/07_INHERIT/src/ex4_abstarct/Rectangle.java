package ex4_abstarct;

public class Rectangle extends Shape{
	
	private int height;
	private int width;
	
	
	
	public Rectangle(int height, int width) {
		super();
		this.height = height;
		this.width = width;
	}



	@Override
	public double getArea() {
		return height * width;
	}
	
	
	

}
