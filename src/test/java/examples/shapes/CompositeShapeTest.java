package examples.shapes;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class CompositeShapeTest {

    @Test
    public void addRemoveShapeTest() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(40, 0);
        Point p3 = new Point(40, 40);
        Point p4 = new Point(0, 40);

        Point p5 = new Point(40, 60);
        Point p6 = new Point(0, 60);

        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
        Square square = new Square(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p5);
        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
        Circle circle = new Circle(200, 200, 40);

        CompositeShape compositeShape = new CompositeShape();
        assertEquals(compositeShape.getItemCount(), 0);

        compositeShape.addShape(triangle);
        assertEquals(compositeShape.getItemCount(), 1);

        compositeShape.addShape(rectangle);
        assertEquals(compositeShape.getItemCount(), 2);

        compositeShape.addShape(square);
        assertEquals(compositeShape.getItemCount(), 3);

        compositeShape.addShape(line);
        assertEquals(compositeShape.getItemCount(), 4);

        compositeShape.addShape(ellipse);
        assertEquals(compositeShape.getItemCount(), 5);

        compositeShape.addShape(circle);
        assertEquals(compositeShape.getItemCount(), 6);

        compositeShape.addShape(p1);
        assertEquals(compositeShape.getItemCount(), 7);

        compositeShape.removeShape(p1);
        assertEquals(compositeShape.getItemCount(), 6);

        compositeShape.removeShape(circle);
        assertEquals(compositeShape.getItemCount(), 5);

        compositeShape.removeShape(ellipse);
        assertEquals(compositeShape.getItemCount(), 4);

        compositeShape.removeShape(line);
        assertEquals(compositeShape.getItemCount(), 3);

        compositeShape.removeShape(square);
        assertEquals(compositeShape.getItemCount(), 2);

        compositeShape.removeShape(rectangle);
        assertEquals(compositeShape.getItemCount(), 1);

        compositeShape.removeShape(triangle);
        assertEquals(compositeShape.getItemCount(), 0);
    }

    @Test
    public void move() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(40, 0);
        Point p3 = new Point(40, 40);
        Point p4 = new Point(0, 40);

        Point p5 = new Point(40, 60);
        Point p6 = new Point(0, 60);

        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
        Square square = new Square(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p5);
        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
        Circle circle = new Circle(200, 200, 40);

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(square);
        compositeShape.addShape(line);
        compositeShape.addShape(ellipse);
        compositeShape.addShape(circle);
        compositeShape.addShape(p1);

        int moveX = 10;
        int moveY = 10;
        compositeShape.move(moveX, moveY);

        rectangle.move(moveX, moveY);
        square.move(moveX, moveY);
        triangle.move(moveX, moveY);
        line.move(moveX, moveY);
        ellipse.move(moveX, moveY);
        circle.move(moveX, moveY);
        p1.move(moveX, moveY);

        CompositeShape movedCompositeShape = new CompositeShape();
        movedCompositeShape.addShape(triangle);
        movedCompositeShape.addShape(rectangle);
        movedCompositeShape.addShape(square);
        movedCompositeShape.addShape(line);
        movedCompositeShape.addShape(ellipse);
        movedCompositeShape.addShape(circle);
        movedCompositeShape.addShape(p1);

        assert movedCompositeShape.equals(compositeShape);
    }

    @Test
    public void area() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(40, 0);
        Point p3 = new Point(40, 40);
        Point p4 = new Point(0, 40);

        Point p5 = new Point(40, 60);
        Point p6 = new Point(0, 60);

        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
        Square square = new Square(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p5);
        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
        Circle circle = new Circle(200, 200, 40);

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(square);
        compositeShape.addShape(line);
        compositeShape.addShape(ellipse);
        compositeShape.addShape(circle);
        compositeShape.addShape(p1);

        double compositeArea = compositeShape.area();
        double individualItemArea = rectangle.area() + square.area() + triangle.area() + line.area() + ellipse.area() +
                circle.area() + p1.area();
        assertEquals(compositeArea, individualItemArea, 0.001);
    }

    @Test
    public void render() throws Exception {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(40, 0);
        Point p3 = new Point(40, 40);
        Point p4 = new Point(0, 40);

        Point p5 = new Point(40, 60);
        Point p6 = new Point(0, 60);

        Rectangle rectangle = new Rectangle(p1, p2, p5, p6);
        Square square = new Square(p1, p2, p3, p4);
        Triangle triangle = new Triangle(p1, p2, p3);
        Line line = new Line(p1, p5);
        Ellipse ellipse = new Ellipse(100, 100, 50, 40);
        Circle circle = new Circle(200, 200, 40);

        CompositeShape compositeShape = new CompositeShape();
        compositeShape.addShape(triangle);
        compositeShape.addShape(rectangle);
        compositeShape.addShape(square);
        compositeShape.addShape(line);
        compositeShape.addShape(ellipse);
        compositeShape.addShape(circle);
        compositeShape.addShape(p1);

        double area = compositeShape.area();
        System.out.println("Computed area of the composite shape is :" + area);

        // Construct the bufferedImage of one of the predefined image types
        BufferedImage bufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_RGB);

        // create a graphics which can be used to draw into buffered image
        Graphics2D graphics = bufferedImage.createGraphics();
        graphics.setColor(Color.white);

        compositeShape.render(graphics);

        // Save as PNG
        File file = new File("image.png");
        ImageIO.write(bufferedImage, "png", file);

        graphics.dispose();

    }

}