
/**
 * RegularPolygon class
 * @author Irem
 * @see SimplePolygon
 */
public class RegularPolygon extends SimplePolygon {

    /**
     * Number of points of the polygon
     */
    protected int numPoints;

    /**
     * Circumcircle Radius of the polygon
     * @see <a href="https://www.omnicalculator.com/math/regular-polygon#regular-polygon-formulas-sides-area-perimeter-angles">https://www.omnicalculator.com/math/regular-polygon#regular-polygon-formulas-sides-area-perimeter-angles</a>
     */
    protected double radius;

    /**
     * Constructor
     * Sets the number of points to 0
     * Sets the radius to 0
     * Sets the center to (0,0)
     * Sets the orientation to 0
     */
    public RegularPolygon() {
        this(0, 1);
    }

    /**
     * Constructor
     * Sets the number of points to numPoints
     * Sets the radius to radius
     * Sets the center to (0,0)
     * Sets the orientation to 0
     * @param numPoints
     * @param radius
     */
    public RegularPolygon(int numPoints, double radius) {
        super();
        this.numPoints = numPoints;
        this.radius = radius;
    }


    /**
     * set the number of points of the polygon
     * @param numPoints
     */
    public void changeNumPoints(int numPoints) {
        this.numPoints = numPoints;
    }

    /**
     * multiplies the radius of the polygon with the scale
     * Its not effective if radius is set to 0
     * @param scale
     */
    @Override
    public void changeScale(double scale) {
        radius *= scale;
    }

    /**
     * Calculates the area of a regular polygon using the formula:
     * A = n × a² × cot(π/n)/ 4
     * where n is the number of sides and a is the length of a side.
     * @see <a href="https://www.mathopenref.com/polygonregulararea.html">https://www.mathopenref.com/polygonregulararea.html</a>
     * @return the area of the polygon
     */
    @Override
    public double getArea() {
        //return n × a² × cot(π/n)/ 4
        double sideLength = getSideLength();
        return numPoints * sideLength * sideLength * Math.pow(Math.tan(Math.PI / numPoints), -1) / 4;
    }

    /**
     * Calculates the perimeter of a regular polygon using the formula:
     * P = n × a
     * where n is the number of sides and a is the length of a side.
     */
    @Override
    public double getPerimeterLength() {
        return numPoints * getSideLength();
    }

    /**
     * Calculates the length of a side of a regular polygon using the formula:
     * a = 2 × r × sin(π/n)
     * where n is the number of sides and r is the radius of the circumcircle.
     * @return the length of a side of the polygon
     */
    public double getSideLength() {
        return 2 * radius * Math.sin(Math.PI / numPoints);
    }

    /**
     * Calculates the vertices of the polygon
     * It also adds orientation to calculates the vertices
     * @return an array of points that are the vertices of the polygon
     */
    public Point[] getVertices() {
        Point[] vertices = new Point[numPoints];
        Point center = getCenter();
        /*
        for (int i = 0; i < numPoints; i++) {
            vertices[i] = new Point(center.getX() + radius * Math.cos(2 * Math.PI * i / numPoints),
                    center.getY() + radius * Math.sin(2 * Math.PI * i / numPoints));
        }
         */
        for (int i = 0; i < numPoints; i++) {
            vertices[i] = new Point(center.getX() + radius * Math.cos(2 * Math.PI * i / numPoints + orientation),
                    center.getY() + radius * Math.sin(2 * Math.PI * i / numPoints + orientation));
        }
        return vertices;
    }
}
