package geometry.shapes.planeShapes;

import java.util.ArrayList;

import geometry.verticies.Vertex;

public class Triangle extends PlaneShape {
	private Vertex pointB;
	private Vertex pointC;
	private double sideA;
	private double sideB;
	private double sideC;
	private ArrayList<Vertex> verticies;

	public Triangle(Vertex pointA, Vertex pointB, Vertex pointC) {
		super(pointA);
		
		this.setPointB(pointB);
		this.setPointC(pointC);
		
		this.sideA = pointC.calculateDistance(pointB);
		this.sideB = pointC.calculateDistance(pointA);
		this.sideC = pointA.calculateDistance(pointB);
		
		this.isValidTriangleCheck();
		
		this.verticies = super.getVertices();
		verticies.add(pointB);
		verticies.add(pointA);
	}
	
	public Vertex getPointB() {
		return this.pointB;
	}
	
	public void setPointB(Vertex pointB) {
		this.pointB = pointB;
	}
	
	public Vertex getPointC() {
		return this.pointC;
	}
	
	public void setPointC(Vertex pointC) {
		this.pointC = pointC;
	}
	
	private void isValidTriangleCheck() {
		boolean isValidA = sideB + sideC > sideA;
		boolean isValidB = sideA + sideC > sideB;
		boolean isValidC = sideA + sideB > sideC;
		
		boolean isValidTriangle = isValidA && isValidB && isValidC;
		
		if (!isValidTriangle) {
			throw new IllegalArgumentException("Your Triangle is not valid");
		}
	}

	@Override
	public double getArea() {
		double halfPerimeter = this.getPerimeter() / 2;
		
		double area = Math.sqrt(
				halfPerimeter * (halfPerimeter - this.sideA) *
				(halfPerimeter - this.sideB) *
				(halfPerimeter - this.sideC));
		
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = this.sideA + this.sideB + this.sideC;
		
		return perimeter;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append(String.format(
				"Triangle:%n"
				+ "SideA = %.2f;%n"
				+ "SideB = %.2f;%n"
				+ "SideC = %.2f;%n"
				+ "Perimeter = %.2f;%n"
				+ "Area = %.2f;%n",
				this.sideA, 
				this.sideB,
				this.sideC,
				this.getPerimeter(),
				this.getArea()));
		output.append(String.format(
				"Coordinates: %s%n",
				this.verticies.toString()));
		
		return output.toString();
	}
}