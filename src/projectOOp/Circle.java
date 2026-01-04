package projectOOp;

public class Circle extends Shape implements Drawable {

	private double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	public Circle(String color, double radius) {
		super(color);
		this.radius = radius;
	}

	public double getRaduis() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public double getPerimeter() {
		return 2 * Math.PI * radius;
	}

	@Override
	public String howToDrwa() {
		return "Draw a circle";
	}

	@Override
	public String toString() {
		return "Circle [radius = " + radius + "]";
	}

	
}
