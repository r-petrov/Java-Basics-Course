package geometry.shapes.planeShapes;

import java.util.ArrayList;

import geometry.verticies.Vertex;

public class Rectangle extends PlaneShape {
	private double hight;
	private double width;
	private ArrayList<Vertex> verticies;

	public Rectangle(Vertex vertex, double width, double hight) {
		super(vertex);

		this.setWidth(width);
		this.setHight(hight);
		this.verticies = super.getVertices();
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double width) {
		if (width <= 0) {
			throw new IllegalArgumentException("Your width can not be negative or zero");
		}
		
		this.width = width;
	}
	
	public double getHight() {
		return this.hight;
	}
	
	public void setHight(double hight) {
		if (hight <= 0) {
			throw new IllegalArgumentException("Your hight can not be negative or zero");
		}
		
		this.hight = hight;
	}

	@Override
	public double getArea() {
		return this.width * this.hight;
	}

	@Override
	public double getPerimeter() {
		return 2 * (this.hight + this.width);
	}
	
	@Override
	public ArrayList<Vertex> getVertices() {
		return this.verticies;
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append(String.format(
				"Rectangle:%n"
				+ "Width = %.2f;%n"
				+ "Hight = %.2f;%n"
				+ "Perimeter = %.2f;%n"
				+ "Area = %.2f;%n",
				this.width, 
				this.hight,
				this.getPerimeter(),
				this.getArea()));
		output.append(String.format(
				"Coordinates: %s%n",
				this.verticies.toString()));
		
		return output.toString();
	}
}