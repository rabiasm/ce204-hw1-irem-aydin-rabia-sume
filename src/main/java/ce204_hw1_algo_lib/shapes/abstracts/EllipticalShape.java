
/**
 * Abstract class for Elliptical shapes
 * @author Rabia
 */
public abstract class EllipticalShape extends Shape2D {

    /**
     * Semi-major axis of the shapes
     */
    protected double semiMajorAxis;


    /**
     * Constructor
     */
    public EllipticalShape() {
        super();
        semiMajorAxis = 1;
    }


}
