package io.github.rabiasm;

import org.junit.Assert;
import org.junit.Test;
import io.github.rabiasm.shapes.Circle;
import io.github.rabiasm.shapes.Point;


public class CircleTest {

    @Test
    public void testArea() {
        Circle circle = new Circle();
        circle.changeScale(10);
        Assert.assertEquals(314.15, circle.getArea(), 0.01);
    }

    @Test
    public void testTranslate() {
        Circle circle = new Circle();
        circle.translate(10, 10);
        circle.changeScale(10);
        Point[] vertices = circle.getBoundingRect().getVertices();
        Point[] expectedVertices = { new Point(0, 20), new Point(20, 20), new Point(20, 0), new Point(0, 0) };
        Assert.assertArrayEquals(expectedVertices, vertices);
    }

    @Test
    public void testPerimeter() {
        Circle circle = new Circle();
        circle.changeScale(5);
        Assert.assertEquals(Math.PI * 2 * 5, circle.getPerimeterLength(), 0.01);
    }
}
