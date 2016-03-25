package geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import geometry.shapes.Shape;
import geometry.shapes.planeShapes.Circle;
import geometry.shapes.planeShapes.PlaneShape;
import geometry.shapes.planeShapes.Rectangle;
import geometry.shapes.planeShapes.Triangle;
import geometry.shapes.spaceShapes.Cuboid;
import geometry.shapes.spaceShapes.SpaceShape;
import geometry.shapes.spaceShapes.Sphere;
import geometry.shapes.spaceShapes.SquarePyramid;
import geometry.verticies.Vertex;
import geometry.verticies.Vertex3D;

public class GeometryMainProgram {

	public static void main(String[] args) {
		Vertex pointA = new Vertex(15, 15);
        Vertex pointB = new Vertex(23, 30);
        Vertex pointC = new Vertex(55, 25);
        Triangle triangle = new Triangle(pointA, pointB, pointC);

        Vertex rectangleVertex = new Vertex(20, 20);
        Rectangle rectangle = new Rectangle(rectangleVertex, 15, 20);

        Vertex circleCenter = new Vertex(30, 30);
        Circle circle = new Circle(circleCenter, 15);

        Vertex3D baseCenter = new Vertex3D(15, 15, 10);
        SquarePyramid squarePyramid = new SquarePyramid(baseCenter, 10, 20);

        Vertex3D cuboidVertex = new Vertex3D(10, 10, 15);
        Cuboid cuboid = new Cuboid(cuboidVertex, 10, 5, 4);

        Vertex3D sphereCenter = new Vertex3D(5, 5, 10);
        Sphere sphere = new Sphere(sphereCenter, 5);

        SpaceShape[] spaceShapes = new SpaceShape[]{squarePyramid, cuboid, sphere};
        PlaneShape[] planeShapes = new PlaneShape[]{triangle, rectangle, circle};

        ArrayList<Shape> shapes = new ArrayList<Shape>() {
            {
                addAll(Arrays.asList(planeShapes));
                addAll(Arrays.asList(spaceShapes));
            }
        };

        shapes.forEach(System.out::println);

        List<SpaceShape> filteredSpaceShapes = shapes.stream()
                .filter(s -> s instanceof SpaceShape)
                .map(s -> (SpaceShape) s)
                .filter(s -> s.getVolume() > 400).collect(Collectors.toList());

        List<PlaneShape> sortedPlaneShapes = shapes.stream()
                .filter(s -> s instanceof PlaneShape)
                .map(s -> (PlaneShape) s)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Space shapes with over 400 volume");
        for (SpaceShape filteredSpaceShape : filteredSpaceShapes) {
            System.out.println(filteredSpaceShape.toString().trim());
        }

        System.out.println();
        System.out.println("Sorted Plane Shapes");
        for (PlaneShape sortedPlaneShape : sortedPlaneShapes) {
            System.out.println(sortedPlaneShape.toString().trim());
        }
	}
}