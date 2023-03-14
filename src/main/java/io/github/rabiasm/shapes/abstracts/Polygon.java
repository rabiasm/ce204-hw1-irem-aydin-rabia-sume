package io.github.rabiasm.shapes.abstracts;

import io.github.rabiasm.Point;

/**
 * Abstract class for Polygon shapes
 * @author Rabia
 */
public abstract class Polygon extends Shape2D {

    /**
     * Constructor
     */
    public Polygon() {
        super();
    }

    /**
     * get the bounding rectangle of the shape
     * @return null bounding rectangle
     */
    public Shape2D getBoundingRect() {
        return null;
    }

    /**
     * get the vertices of the shape
     * @return null vertices
     */
    public Point[] getVertices() {
        return null;
    }
}
