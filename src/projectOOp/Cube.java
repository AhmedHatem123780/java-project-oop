package projectOOp;

public class Cube extends ThreeDShape {
    private double side;
	

	public Cube(double side) {
	 super();
		this.side=side;
	}
	public Cube(String color,double side) {
		super(color);
		this.side=side;
	}
	

	public double getSide() {
		return side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	@Override
	public String howToDrwa() {
		
		return "Cube";
	}

	@Override
	public double getVolume() {
		
		return Math.pow(side,3);
	}

	@Override
	public double getArea() {
	
		return 6* Math.pow(side,2);
	}

	@Override
	public double getPerimeter() {
		
		return 12*side;
	}

}
