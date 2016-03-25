package geometry.shapes;

import java.util.ArrayList;

import geometry.interfaces.IVertex;

public abstract class Shape {
	private ArrayList<IVertex> verticies;
	
	protected Shape() {
		this.verticies = new ArrayList<>();
	}
}