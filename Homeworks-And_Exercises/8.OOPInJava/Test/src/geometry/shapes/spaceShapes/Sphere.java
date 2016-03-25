package geometry.shapes.spaceShapes;

import java.util.ArrayList;

import geometry.verticies.Vertex3D;

public class Sphere extends SpaceShape {
	private double radius;
	private ArrayList<Vertex3D> vertices;
	
	public Sphere(Vertex3D center, double radius) {
		super(center);
		
		this.setRadius(radius);
		this.vertices = super.getVertices();
	}
	
	public double getRadius()
	{
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
        double area = 4 * Math.PI * this.radius * this.radius;
        return area;
    }

    @Override
    public double getVolume() {
        double volume = (double) 4 / 3 * Math.PI * this.radius * this.radius * this.radius;
        return volume;
    }

    @Override
     public String toString(){
        StringBuilder sphere = new StringBuilder();
        sphere.append(String.format(
                "Sphere:%nCenter = %s;%nRadius = %.2f;%nVolume = %.2f;%nArea = %.2f;%n",
                super.getVertex(), this.radius, this.getVolume(), this.getArea()));

        return sphere.toString();
    }
}