package chuong2;
import java.util.Arrays;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class ConvexHull {
    static Point p0;

    static void swap(Point p1, Point p2) {
        int tempX = p1.x;
        int tempY = p1.y;
        p1.x = p2.x;
        p1.y = p2.y;
        p2.x = tempX;
        p2.y = tempY;
    }

    static int distSq(Point p1, Point p2) {
        return (p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y) * (p1.y - p2.y);
    }

    static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0)
            return 0;
        return (val > 0) ? 1 : 2;
    }

    static int compare(Point p1, Point p2) {
        int o = orientation(p0, p1, p2);
        if (o == 0)
            return (distSq(p0, p2) >= distSq(p0, p1)) ? -1 : 1;
        return (o == 2) ? -1 : 1;
    }

    static void convexHull(Point[] points, int n) {
        int ymin = points[0].y, min = 0;
        for (int i = 1; i < n; i++) {
            int y = points[i].y;
            if ((y < ymin) || (ymin == y && points[i].x < points[min].x))
                ymin = points[i].y;
            min = i;
        }
        swap(points[0], points[min]);
        p0 = points[0];
        Arrays.sort(points, 1, n, ConvexHull::compare);

        int m = 1;
        for (int i = 1; i < n; i++) {
            while (i < n - 1 && orientation(p0, points[i], points[i + 1]) == 0)
                i++;
            points[m] = points[i];
            m++;
        }

        if (m < 3)
            return;

        int top = 2;
        for (int i = 3; i < m; i++) {
            while (top > 0 && orientation(points[top - 2], points[top - 1], points[i]) != 2)
                top--;
            points[top] = points[i];
            top++;
        }

        for (int i = 0; i < top; i++) {
            System.out.println("(" + points[i].x + ", " + points[i].y + ")");
        }
    }

    public static void main(String[] args) {
        Point points[] = {
                new Point(1, 2),
                new Point(2, 5),
                new Point(3, 4),
                new Point(4, 3),
                new Point(5, 4),
                new Point(6, 1),
                new Point(7, 5)
        };

        int n = points.length;
        convexHull(points, n);
    }
}
