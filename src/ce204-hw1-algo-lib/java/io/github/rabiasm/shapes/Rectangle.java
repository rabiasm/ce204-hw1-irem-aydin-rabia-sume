package io.github.rabiasm.shapes;

import org.example.Point;
import org.example.shapes.abstracts.SimplePolygon;

/**
 * Rectangle class
 * @author Irem
 * @see SimplePolygon
 */
public class Rectangle extends SimplePolygon {

    /**
     * Height of the rectangle
     */
    protected double height;

    /**
     * Width of the rectangle
     */
    protected double width;

    /**
     * Constructor
     * Sets the width and height to 0
     * Sets the center to (0,0)
     * Sets the orientation to 0
     */
    public Rectangle() {
        super();
        width = 0;
        height = 0;
    }

    /**
     * change the scale of the shape
     * multiply the width and height by the scale
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        width *= scale;
        height *= scale;
    }

    /**
     * set the height of the rectangle
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * set the width of the rectangle
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * get the height of the rectangle
     * A = w * h
     * w is the width of the rectangle and h is the height of the rectangle
     * @return height
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * get the perimeter length of the rectangle
     * P = 2 * (w + h)
     * w is the width of the rectangle and h is the height of the rectangle
     * @return perimeter length
     */
    @Override
    public double getPerimeterLength() {
        return 2 * (width + height);
    }

    /**
     * get the vertices of the rectangle
     * @return vertices
     */
    public Point[] getVertices() {
        Point[] vertices = new Point[4];
        Point center = getCenter();
        /*
        vertices[0] = new Point(center.getX() - width / 2, center.getY() - height / 2);
        vertices[1] = new Point(center.getX() + width / 2, center.getY() - height / 2);
        vertices[2] = new Point(center.getX() + width / 2, center.getY() + height / 2);
        vertices[3] = new Point(center.getX() - width / 2, center.getY() + height / 2);
         */

        vertices[0] = new Point(center.getX() - width / 2 * Math.cos(orientation) - height / 2 * Math.sin(orientation),
                center.getY() - width / 2 * Math.sin(orientation) + height / 2 * Math.cos(orientation));
        vertices[1] = new Point(center.getX() + width / 2 * Math.cos(orientation) - height / 2 * Math.sin(orientation),
                center.getY() + width / 2 * Math.sin(orientation) + height / 2 * Math.cos(orientation));
        vertices[2] = new Point(center.getX() + width / 2 * Math.cos(orientation) + height / 2 * Math.sin(orientation),
                center.getY() + width / 2 * Math.sin(orientation) - height / 2 * Math.cos(orientation));
        vertices[3] = new Point(center.getX() - width / 2 * Math.cos(orientation) + height / 2 * Math.sin(orientation),
                center.getY() - width / 2 * Math.sin(orientation) - height / 2 * Math.cos(orientation));
        return vertices;
    }

    
    /**
     * get the bounding rectangle of the rectangle
     * Returns the smallest rectangle that contains the rectangle
     * While the rectangle is not rotated, the bounding rectangle is the rectangle itself
     * When the rectangle is rotated, the bounding rectangle is the smallest rectangle that contains the rectangle
     * @return bounding rectangle
     */
    public Rectangle getBoundingRect() {
        Point[] vertices = getVertices();
        double minX = vertices[0].getX();
        double maxX = vertices[0].getX();
        double minY = vertices[0].getY();
        double maxY = vertices[0].getY();
        for (int i = 1; i < vertices.length; i++) {
            if (vertices[i].getX() < minX) {
                minX = vertices[i].getX();
            }
            if (vertices[i].getX() > maxX) {
                maxX = vertices[i].getX();
            }
            if (vertices[i].getY() < minY) {
                minY = vertices[i].getY();
            }
            if (vertices[i].getY() > maxY) {
                maxY = vertices[i].getY();
            }
        }
        Rectangle boundingRect = new Rectangle();
        boundingRect.setCenter(center);
        boundingRect.setWidth(maxX - minX);
        boundingRect.setHeight(maxY - minY);
        return boundingRect;
    }
}
