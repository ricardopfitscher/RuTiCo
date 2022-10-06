import java.util.*;
import java.io.*;

public class Three{
    public static void main(String[] args) {
	Scanner in = new Scanner (System.in);
	PrintWriter out = new PrintWriter(System.out);

	pair[] points = new pair [3];
	for (int i = 0; i < 3; ++i) {
	    int x = in.nextInt();
	    int y = in.nextInt();
	    points[i] = new pair (x, y);
	}

	Arrays.sort(points);

	int MaxY = Math.max(Math.max(points[0].y, points[1].y), points[2].y);
	int MinY = Math.min(Math.min(points[0].y, points[1].y), points[2].y);

	out.println(MaxY - MinY + points[2].x - points[0].x + 1);
	for (int i = MinY; i <= MaxY; ++i)
	    out.println(points[1].x + " " + i);
	for (int i = points[0].x; i < points[1].x; ++i)
	    out.println(i + " " + points[0].y);
	for (int i = points[1].x + 1; i <= points[2].x; ++i)
	    out.println(i + " " + points[2].y);
	
	out.close();
    }

    public static class pair implements Comparable<pair> {
	int x, y;
	public pair (int x_, int y_) {
	    x = x_; y = y_;
	}

	@Override
	public int compareTo(pair o) {
	    return x - o.x;
	}
    }
}
