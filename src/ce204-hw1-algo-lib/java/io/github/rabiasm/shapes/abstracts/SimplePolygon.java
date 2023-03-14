package io.github.rabiasm.shapes.abstracts;

/**
 * Abstract class for SimplePolygon shapes
 * @author Rabia
 */
public abstract class SimplePolygon extends Polygon {

    /**
     * Orientation of the shape
     */
    protected double orientation;

    /**
     * Constructor
     */
    public SimplePolygon() {
        super();
        orientation = 0;
    }

    /**
     * rotate the shape around the center
     * @param degree
     * @return
     */
    @Override
    public void rotate(double degree) {
        this.orientation += degree;
    }

    /**
     * get the orientation of the shape
     * @return orientation
     */
    public double getOrientation() {
        return orientation;
    }
}
