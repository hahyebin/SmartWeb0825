package ex6_constructor;

public class Rectangle {
	
	private double width;
	private double height;
	
	
	public double getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public Rectangle(double width, double height) {
		this.height = height;
		this.width = width;
	}
	
	
	//혼자 구현한 코드
	public double area() {
		return width*height;
	}

}
