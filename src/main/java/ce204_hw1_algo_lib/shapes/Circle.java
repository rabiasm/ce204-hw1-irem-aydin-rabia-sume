package ce204_hw1_algo_lib.shapes;

import ce204_hw1_algo_lib.shapes.abstracts.EllipticalShape;

/**
 * Circle class
 * @author Rabia
 * @see EllipticalShape
 */
public class Circle extends EllipticalShape {

    /**
     * Constructor
     * Sets the semi-major axis to 1
     * Sets the center to (0,0)
     */
    public Circle() {
        super();
    }

    /**
     * rotate the shape around the center
     * for a circle, this is a no-op
     * @param degree
     * @return
     */
    @Override
    public void rotate(double degree) {}

    /**
     * change the scale of the shape
     * multiply the semi-major axis by the scale
     * It is effectless if the semi-major axis is zero
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        semiMajorAxis *= scale;
    }


    /**
     * get the area of the shape
     * A = pi * r^2
     * @return area
     */
    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMajorAxis;
    }

    /**
     * get the perimeter length of the shape
     * P = pi * r^2
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * Math.PI * semiMajorAxis;
    }

    /**
     * get the bounding rectangle of the shape
     * @return bounding rectangle
     */
    @Override
    public Rectangle getBoundingRect() {
        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(semiMajorAxis * 2);
        boundingRect.setHeight(semiMajorAxis * 2);
        return boundingRect;
    }
}
