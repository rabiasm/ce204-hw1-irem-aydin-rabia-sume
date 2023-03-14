package io.github.rabiasm;

import org.junit.Assert;
import org.junit.Test;
import io.github.rabiasm.shapes.Point;
import io.github.rabiasm.shapes.ArbitraryPolygon;

public class ArbitraryPolygonTest {

    @Test
    public void testArea() {
        ArbitraryPolygon arbitraryPolygon = new ArbitraryPolygon();
        arbitraryPolygon.addPoint(0, 0);
        arbitraryPolygon.addPoint(0, 2);
        arbitraryPolygon.addPoint(2, 2);
        arbitraryPolygon.addPoint(2, 0);

        double expectedArea = 4;
        Assert.assertEquals(expectedArea, arbitraryPolygon.getArea(), 0.01);
    }

    @Test
    public void testPerimeter() {
        ArbitraryPolygon arbitraryPolygon = new ArbitraryPolygon();
        arbitraryPolygon.addPoint(0, 0);
        arbitraryPolygon.addPoint(0, 2);
        arbitraryPolygon.addPoint(2, 2);
        arbitraryPolygon.addPoint(2, 0);

        double expectedPerimeter = 8;
        Assert.assertEquals(expectedPerimeter, arbitraryPolygon.getPerimeterLength(), 0.01);
    }
	
}