package io.github.rabiasm;

import org.junit.Assert;
import org.junit.Test;
import io.github.rabiasm.shapes.Point;
import io.github.rabiasm.shapes.RegularPolygon;

public class RegularPolygonTest {
	

    @Test
    public void testArea() {
        regularPolygon.changeNumPoints(3);
        regularPolygon.changeScale(4);
        double expectedArea = 20.785;
        Assert.assertEquals(expectedArea, regularPolygon.getArea(), 0.01);
    }

    @Test
    public void testPerimeter() {
        RegularPolygon regularPolygon = new RegularPolygon();
        regularPolygon.changeNumPoints(3);
        regularPolygon.changeScale(4);
        double expectedPerimeter = 20.785;
        Assert.assertEquals(expectedPerimeter, regularPolygon.getPerimeterLength(), 0.01);
    }

    @Test
    public void testTranslate() {
        RegularPolygon regularPolygon = new RegularPolygon();
        regularPolygon.changeNumPoints(3);
        regularPolygon.changeScale(4);
        regularPolygon.translate(10, 10);
        double expectedPerimeter = 20.785;
        Assert.assertEquals(expectedPerimeter, regularPolygon.getPerimeterLength(), 0.01);
    }
}
