package geometry.shapes.planeShapes;

import java.util.ArrayList;

import geometry.verticies.Vertex;

public class Circle extends PlaneShape {
	private Vertex centrum;
	private double radius;
	private ArrayList<Vertex> vertices;

	public Circle(Vertex centrum, double radius)  {
		super(centrum);
		this.centrum = super.getVertex();
		this.setRadius(radius);
		this.vertices = super.getVertices();
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("Your radius can not be negative or zero");
		}
		
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	@Override
	public double getPerimeter() {
		return 2.0 * Math.PI * this.radius;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append(String.format(
				"Circle:%n"
				+ "Center = %s;%n"
				+ "Radius = %.2f;%n"
				+ "Perimeter = %.2f;%n"
				+ "Area = %.2f;%n", 
				this.centrum, 
				this.radius, 
				this.getPerimeter(),
				this.getArea()));
		
		return output.toString();
	}
}