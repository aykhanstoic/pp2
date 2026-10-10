package pp2.week03.geometry;

/**
 * A line segment between two end points p1 and p2.
 * The line through the segment is y = k*x + b (k = slope, b = intercept).
 */
public class Segment {

    private Point p1;
    private Point p2;

    /** Constructs a segment from two points. Copies are stored so that
     *  later changes to the caller's points do not silently change the segment. */
    public Segment(Point p1, Point p2) {
        this.p1 = new Point(p1);
        this.p2 = new Point(p2);
    }

    /** Constructs a segment directly from four coordinates. */
    public Segment(float x1, float y1, float x2, float y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    // ---- accessors / modifiers ----

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p) {
        this.p1 = new Point(p);
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p) {
        this.p2 = new Point(p);
    }

    // ---- behaviour ----

    /** Moves the whole segment by (dX, dY) - both ends move together. */
    public void translate(float dX, float dY) {
        p1.translate(dX, dY);
        p2.translate(dX, dY);
    }

    /** Length of the segment = distance between its end points. */
    public float length() {
        return p1.distance(p2);
    }

    /** Two segments are equal if they have the same end points (in either order). */
    public boolean equals(Segment s) {
        if (s == null) {
            return false;
        }
        boolean sameOrder = p1.equals(s.p1) && p2.equals(s.p2);
        boolean swapped = p1.equals(s.p2) && p2.equals(s.p1);
        return sameOrder || swapped;
    }

    /** True if the segment is vertical (x1 == x2); such a line has no finite slope. */
    public boolean isVertical() {
        return Math.abs(p2.getX() - p1.getX()) < Point.EPS;
    }

    /** Slope k = (y2 - y1) / (x2 - x1). Returns +Infinity for a vertical segment. */
    public float getSlope() {
        if (isVertical()) {
            return Float.POSITIVE_INFINITY;
        }
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

    /** Intercept b = y1 - k*x1 (where the line crosses the y-axis).
     *  A vertical line never crosses the y-axis, so NaN is returned. */
    public float getIntercept() {
        if (isVertical()) {
            return Float.NaN;
        }
        return p1.getY() - getSlope() * p1.getX();
    }

    /** True if p lies on the (infinite) line through p1 and p2,
     *  i.e. it satisfies y = k*x + b. */
    public boolean isOnLine(Point p) {
        if (isVertical()) {
            // every point on a vertical line shares the same x
            return Math.abs(p.getX() - p1.getX()) < Point.EPS;
        }
        float expectedY = getSlope() * p.getX() + getIntercept();
        return Math.abs(p.getY() - expectedY) < Point.EPS;
    }

    /** True if p is on the line AND between the two end points. */
    public boolean isOnSegment(Point p) {
        if (!isOnLine(p)) {
            return false;
        }
        float minX = Math.min(p1.getX(), p2.getX());
        float maxX = Math.max(p1.getX(), p2.getX());
        float minY = Math.min(p1.getY(), p2.getY());
        float maxY = Math.max(p1.getY(), p2.getY());

        boolean xInRange = p.getX() >= minX - Point.EPS && p.getX() <= maxX + Point.EPS;
        boolean yInRange = p.getY() >= minY - Point.EPS && p.getY() <= maxY + Point.EPS;
        return xInRange && yInRange;
    }

    @Override
    public String toString() {
        return "[" + p1 + " -> " + p2 + "]";
    }
}
