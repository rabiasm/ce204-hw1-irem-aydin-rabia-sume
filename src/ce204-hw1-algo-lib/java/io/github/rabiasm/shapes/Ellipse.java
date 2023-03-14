package io.github.rabiasm.shapes;


import org.example.Point;
import org.example.shapes.abstracts.EllipticalShape;

/**
 * Ellipse class
 * @author Rabia
 * @see EllipticalShape
 */
public class Ellipse extends EllipticalShape {

    /**
     * Semi-minor axis of the ellipse
     * other axis is semi-major axis which is inherited from EllipticalShape
     * @see EllipticalShape
     */
    protected double semiMinorAxis;

    /**
     * Orientation of the ellipse
     */
    protected double orientation;

    /**
     * Constructor
     * Sets the semi-major axis to 1
     * Sets the semi-minor axis to 1
     * Sets the center to (0,0)
     */
    public Ellipse() {
        super();
        semiMinorAxis = 1;
        orientation = 0;
    }


    /**
     * rotate the shape around the center
     * @param degree
     */
    @Override
    public void rotate(double degree) {
        orientation += degree;
    }

    /**
     * change the scale of the shape
     * multiply the semi-major axis and semi-minor axis by the scale
     * It is effectless if the semi-major axis is zero
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        semiMajorAxis *= scale;
        semiMinorAxis *= scale;
    }

    /**
     * get the area of the shape
     * A = pi * a * b
     * a is semi-major axis and b is semi-minor axis
     * @return area
     */
    @Override
    public double getArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    /**
     * get the perimeter length of the shape
     * P = 2 * pi * sqrt((a^2 + b^2) / 2)
     * a is semi-major axis and b is semi-minor axis
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * Math.PI * Math.sqrt((semiMajorAxis * semiMajorAxis + semiMinorAxis * semiMinorAxis) / 2);
    }

    /**
     * get the bounding rectangle of the shape
     * while the orientation is 0, the bounding rectangle is the rectangle that contains the shape
     * while the orientation is not 0, the bounding rectangle is needs to be calculated using trigonometry
     * @return bounding rectangle
     */
    @Override
    public Rectangle getBoundingRect() {
        double topHeight = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.cos(Math.toRadians(orientation)), 2));
        double bottomHeight = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.cos(Math.toRadians(orientation + 90)), 2));
        double leftWidth = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.sin(Math.toRadians(orientation)), 2));
        double rightWidth = semiMinorAxis * Math.sqrt(1 - Math.pow(semiMajorAxis / semiMinorAxis, 2) * Math.pow(Math.sin(Math.toRadians(orientation + 90)), 2));

        double width = leftWidth + rightWidth;
        double height = topHeight + bottomHeight;

        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(width);
        boundingRect.setHeight(height);
        return boundingRect;
    }

    /**
     * get the semi-minor axis of the ellipse
     * @return semi-minor axis
     */
    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }


    /**
     * get the semi-major axis of the ellipse
     * @return semi-major axis
     */
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }


    /**
     * get the first focus of the ellipse
     * see <a href="https://en.wikipedia.org/wiki/Ellipse">https://en.wikipedia.org/wiki/Ellipse</a>
     * @return first focus
     */
    public Point getFocus1() {
        double c = Math.sqrt(semiMajorAxis * semiMajorAxis - semiMinorAxis * semiMinorAxis);
        double x = center.getX() + c * Math.cos(Math.toRadians(orientation));
        double y = center.getY() + c * Math.sin(Math.toRadians(orientation));
        return new Point(x, y);
    }

    /**
     * get the second focus of the ellipse
     * see <a href="https://en.wikipedia.org/wiki/Ellipse">https://en.wikipedia.org/wiki/Ellipse</a>
     * @return second focus
     */
    public Point getFocus2() {
        double c = Math.sqrt(semiMajorAxis * semiMajorAxis - semiMinorAxis * semiMinorAxis);
        double x = center.getX() - c * Math.cos(Math.toRadians(orientation));
        double y = center.getY() - c * Math.sin(Math.toRadians(orientation));
        return new Point(x, y);
    }

    /**
     * set the semi-minor axis of the ellipse
     * @param semiMinorAxis
     */
    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    /**
     * set the semi-major axis of the ellipse
     * @param semiMajorAxis
     */
    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    /**
     * get the orientation of the ellipse
     * @return orientation
     */
    public double getOrientation() {
        return orientation;
    }

    /**
     * set the orientation of the ellipse
     * @param orientation orientation
     */
    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }
}
