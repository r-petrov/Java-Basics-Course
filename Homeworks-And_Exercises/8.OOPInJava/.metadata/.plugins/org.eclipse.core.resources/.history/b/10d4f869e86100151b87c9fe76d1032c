package geometry.shapes.spaceShapes;

import java.util.ArrayList;

import geometry.verticies.Vertex3D;

public class SquarePyramid extends SpaceShape {

	private double baseWidth;
	private double pyramidHight;
	private ArrayList<Vertex3D> vertices;

	public SquarePyramid(
			Vertex3D baseCenter,
			double baseWidth,
			double pyramidHight) {
		
		super(baseCenter);
		
		this.setBaseWidth(baseWidth);
		this.setPyramidHight(pyramidHight);

        this.vertices = super.getVertices();
    }

    public double getBaseWidth() {
        return this.baseWidth;
    }

    public void setBaseWidth(double baseWidth) {
        this.baseWidth = baseWidth;
    }

    public double getPyramidHight() {
        return this.pyramidHight;
    }

    public void setPyramidHight(double pyramidHight) {
        this.pyramidHight = pyramidHight;
    }

    @Override
    public double getArea() {
        double surfaceArea = this.baseWidth * this.baseWidth + 2 * this.baseWidth * 
        		Math.sqrt((this.baseWidth * this.baseWidth) / 4 + 
                		this.pyramidHight * this.pyramidHight);

        return surfaceArea;
    }

    @Override
    public double getVolume() {
        double volume = (this.baseWidth * this.baseWidth) * this.pyramidHight / 3;
        return volume;
    }

    @Override
    public String toString() {
        StringBuilder squarePyramid = new StringBuilder();
        squarePyramid.append(String.format(
                "Square Pyramid:%nBase Center = %s;%nBase Width = %.2f;%nHeight = %.2f;%nVolume = %.2f;%nArea = %.2f;%n",
                super.getVertex().toString(), this.baseWidth, this.pyramidHight, this.getVolume(), this.getArea()));

        return squarePyramid.toString();
	}
}