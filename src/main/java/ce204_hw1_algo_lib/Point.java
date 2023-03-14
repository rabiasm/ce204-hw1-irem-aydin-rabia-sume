package ce204_hw1_algo_lib;


/**
 * Point class
 * @author Rabia
 */
public class Point {

    /**
     * x and y coordinates of the point
     */
    private double x;
    private double y;

    /**
     * Constructor
     */
    public Point() {
        x = 0;
        y = 0;
    }

    /**
     * Constructor
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get x coordinate of the point
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * set x coordinate of the point
     * @param x x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * get y coordinate of the point
     * @return y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * set y coordinate of the point
     * @param y y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * rotates the point around the center using the given degree and distance from the center
     * @param degree degree to rotate
     * @param center center of rotation
     */
    public void rotate(double degree, Point center) {
        double x = this.x - center.x;
        double y = this.y - center.y;

        double rad = Math.toRadians(degree);
        this.x = x * Math.cos(rad) - y * Math.sin(rad) + center.x;
        this.y = x * Math.sin(rad) + y * Math.cos(rad) + center.y;
    }

    /**
     * translate the point
     * @return string representation of the point
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * equals method
     * @param obj
     * @return true if the points are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Point other = (Point) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
}


