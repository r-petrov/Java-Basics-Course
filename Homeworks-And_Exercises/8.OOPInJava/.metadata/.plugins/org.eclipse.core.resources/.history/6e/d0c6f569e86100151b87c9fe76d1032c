package geometry.shapes.spaceShapes;

import java.util.ArrayList;

import geometry.interfaces.AreaMeasurable;
import geometry.interfaces.VolumeMeasurable;
import geometry.shapes.Shape;
import geometry.verticies.Vertex3D;

public abstract class SpaceShape extends Shape
	implements AreaMeasurable, VolumeMeasurable {
	
	private Vertex3D vertex;
	private ArrayList<Vertex3D> vertices;

	protected SpaceShape(Vertex3D vertex) {
		this.setVertex(vertex);
		this.vertices = new ArrayList<Vertex3D>() {{
			add(vertex);
		}};
	}
	
	public Vertex3D getVertex() {
		return this.vertex;
	}
	
	public void setVertex(Vertex3D vertex) {
		this.vertex = vertex;
	}
	
	public ArrayList<Vertex3D> getVertices() {
		return this.vertices;
	}
}