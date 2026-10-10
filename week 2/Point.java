package pp2.week03.geometry;

/**
 * A point in the 2D plane with float coordinates.
 */
public class Point {

    /** Tolerance used when comparing floats (floats are never exactly equal after arithmetic). */
    public static final float EPS = 1e-5f;

    private float x;
    private float y;

    /** Default constructor: the origin (0, 0). */
    public Point() {
        this(0f, 0f);
    }

    /** Constructs a point from its coordinates. */
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /** Copy constructor: a new Point with the same coordinates as p. */
    public Point(Point p) {
        this(p.x, p.y);
    }

    // ---- accessors (getters) / modifiers (setters) ----

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    // ---- behaviour ----

    /** Moves this point by (dX, dY). */
    public void translate(float dX, float dY) {
        x += dX;
        y += dY;
    }

    /** Euclidean distance between this point and p. */
    public float distance(Point p) {
        float dx = x - p.x;
        float dy = y - p.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    /** True if both coordinates match (within EPS). */
    public boolean equals(Point p) {
        if (p == null) {
            return false;
        }
        return Math.abs(x - p.x) < EPS && Math.abs(y - p.y) < EPS;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
