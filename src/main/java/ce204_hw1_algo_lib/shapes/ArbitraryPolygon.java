package ce204_hw1_algo_lib.shapes;

import java.util.ArrayList;
import java.util.List;

import ce204_hw1_algo_lib.Point;
import ce204_hw1_algo_lib.shapes.abstracts.Polygon;


/**
 * A polygon with arbitrary number of vertices.
 * @author Irem
 * @see Polygon
 * <p>
 *     The vertices are stored in a list.
 *     The last vertex is connected to the first vertex.
 * </p>
 */
public class ArbitraryPolygon extends Polygon {

    /**
     * The vertices of the polygon.
     * The vertices are stored in a list. As Point objects.
     */
    protected List<Point> vertices;

    /**
     * Create a new polygon with no vertices.
     */
    public ArbitraryPolygon() {
        this.vertices = new ArrayList();
    }

    /**
     * Create a new polygon with the given vertices.
     * @param vertices The vertices of the polygon.
     */
    public ArbitraryPolygon(List<Point> vertices) {
        this.vertices = vertices;
    }

    /**
     * Add a point to the polygon.
     * @param point The point to be added.
     */
    public void addPoint(Point point) {
        vertices.add(point);
    }

    /**
     * Add a point to the polygon.
     * @param x The x-coordinate of the point to be added.
     * @param y The y-coordinate of the point to be added.
     */
    public void addPoint(double x, double y) {
        vertices.add(new Point(x, y));
    }

    /**
     * Rotate the polygon around its center.
     * @param degree The degree of rotation.
     */
    public void rotate(double degree) {
        for (Point point : vertices) {
            point.rotate(degree, getCenter());
        }
    }

    /**
     * Change the scale of the polygon with respect to its center.
     * @param scale The scaling factor.
     */
    @Override
    public void changeScale(double scale) {
        Point center = getCenter();
        for (Point point : vertices) {
            point.setX(point.getX() + (point.getX() - center.getX()) * scale);
            point.setY(point.getY() + (point.getY() - center.getY()) * scale);
        }
    }

    /**
     * Calculate the area of the polygon.
     * The formula used for calculating the area of a polygon is:
     *     area = 1/2 * |x1y2 + x2y3 + ... + xny1 - y1x2 - y2x3 - ... - ynx1|
     * where n is the number of vertices, and (xi, yi) is the ith vertex.
     *
     * @return The area of the polygon.
     */
    @Override
    public double getArea() {
        int n = vertices.size();
        double area = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            Point p1 = vertices.get(i);
            Point p2 = vertices.get(j);
            area += p1.getX() * p2.getY();
            area -= p1.getY() * p2.getX();
        }
        area /= 2;
        return Math.abs(area);
    }

    /**
     * Calculate the perimeter length of the polygon.
     * The formula used for calculating the perimeter length of a polygon is:
     *     perimeter = sqrt((x2 - x1)^2 + (y2 - y1)^2) + sqrt((x3 - x2)^2 + (y3 - y2)^2) + ... + sqrt((x1 - xn)^2 + (y1 - yn)^2)
     * where n is the number of vertices, and (xi, yi) is the ith vertex.
     *
     * @return The perimeter length of the polygon.
     */
    @Override
    public double getPerimeterLength() {
        int n = vertices.size();
        double perimeter = 0;
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            Point p1 = vertices.get(i);
            Point p2 = vertices.get(j);
            double dx = p2.getX() - p1.getX();
            double dy = p2.getY() - p1.getY();
            perimeter += Math.sqrt(dx * dx + dy * dy);
        }
        return perimeter;
    }
}