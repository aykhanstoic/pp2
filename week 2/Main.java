package pp2.week03.geometry;

public class Main {

    public static void main(String[] args) {
        System.out.println("===== Point =====");

        Point origin = new Point();                 // default constructor
        Point a = new Point(3f, 4f);                // parameterised constructor
        Point aCopy = new Point(a);                 // copy constructor

        System.out.println("origin = " + origin);
        System.out.println("a      = " + a);
        System.out.println("aCopy  = " + aCopy);

        // getters / setters
        a.setX(6f);
        a.setY(8f);
        System.out.println("after setX(6), setY(8): a = (" + a.getX() + ", " + a.getY() + ")");
        System.out.println("aCopy is unchanged: " + aCopy + "  (copy is independent)");

        // distance: (0,0) -> (6,8) = 10
        System.out.println("origin.distance(a) = " + origin.distance(a));

        // translate
        a.translate(-6f, -8f);
        System.out.println("after translate(-6, -8): a = " + a);

        // equals
        System.out.println("a.equals(origin)  = " + a.equals(origin));
        System.out.println("a.equals(aCopy)   = " + a.equals(aCopy));

        System.out.println();
        System.out.println("===== Segment =====");

        Segment s1 = new Segment(new Point(0f, 0f), new Point(4f, 3f));   // from points
        Segment s2 = new Segment(4f, 3f, 0f, 0f);                         // from coordinates (reversed)
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);

        // length: 3-4-5 triangle -> 5
        System.out.println("s1.length() = " + s1.length());

        // equals (same end points, opposite order)
        System.out.println("s1.equals(s2) = " + s1.equals(s2));

        // slope and intercept: y = 0.75x + 0
        System.out.println("s1.getSlope()     = " + s1.getSlope());
        System.out.println("s1.getIntercept() = " + s1.getIntercept());

        // isOnLine / isOnSegment
        Point onSeg = new Point(2f, 1.5f);      // on the line and between the ends
        Point onLineOnly = new Point(8f, 6f);   // on the line but beyond p2
        Point offLine = new Point(2f, 2f);      // not on the line at all
        System.out.println("isOnLine(2,1.5)    = " + s1.isOnLine(onSeg)
                + ", isOnSegment = " + s1.isOnSegment(onSeg));
        System.out.println("isOnLine(8,6)      = " + s1.isOnLine(onLineOnly)
                + ", isOnSegment = " + s1.isOnSegment(onLineOnly));
        System.out.println("isOnLine(2,2)      = " + s1.isOnLine(offLine)
                + ", isOnSegment = " + s1.isOnSegment(offLine));

        // getters / setters
        s1.setP2(new Point(4f, 0f));
        System.out.println("after setP2(4,0): s1 = " + s1
                + ", getP1() = " + s1.getP1() + ", getP2() = " + s1.getP2());

        // translate
        s1.translate(1f, 1f);
        System.out.println("after translate(1,1): s1 = " + s1
                + ", slope = " + s1.getSlope() + ", intercept = " + s1.getIntercept());

        // vertical segment: slope is undefined
        Segment vertical = new Segment(2f, 0f, 2f, 5f);
        System.out.println("vertical = " + vertical
                + ", slope = " + vertical.getSlope()
                + ", intercept = " + vertical.getIntercept());
        System.out.println("vertical.isOnLine(2,10)    = " + vertical.isOnLine(new Point(2f, 10f)));
        System.out.println("vertical.isOnSegment(2,10) = " + vertical.isOnSegment(new Point(2f, 10f)));
        System.out.println("vertical.isOnSegment(2,3)  = " + vertical.isOnSegment(new Point(2f, 3f)));
    }
}
