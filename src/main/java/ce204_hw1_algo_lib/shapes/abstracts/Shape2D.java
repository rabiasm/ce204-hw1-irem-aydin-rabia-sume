package ce204_hw1_algo_lib.shapes.abstracts;

import ce204_hw1_algo_lib.Point;

/**
 * Abstract class for 2D shapes
 * @author Rabia
 */
public abstract class Shape2D {

    /**
     * Center of the shape
     */
    protected Point center;

    /**
     * Constructor
     */
    public Shape2D() {
        center = new Point();
    }

    /**
     * translate the shape to the given point
     * @param dx
     * @param dy
     * @return
     */
    public void translate(double dx, double dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }

    /**
     * get the center of the shape
     * @return center
     */
    public Point getCenter() {
        return center;
    }

    /**
     * set the center of the shape
     * @param center
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * rotate the shape around the center
     * @param degree
     */
    public abstract void rotate(double degree);

    /**
     * scale the shape around the center
     * @param scale
     */
    public abstract void changeScale(double scale);

    /**
     * get the area of the shape
     * @return area
     */
    public abstract double getArea();

    /**
     * get the perimeter length of the shape
     * @return perimeter length
     */
    public abstract double getPerimeterLength();

    /**
     * get the bounding rectangle of the shape
     * @return bounding rectangle
     */
    public abstract Shape2D getBoundingRect();

}
