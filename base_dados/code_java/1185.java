
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class cf2 {
	static final double EPS = 1e-9;

  public static void main(String[] args) throws IOException {
	 Scanner sc = new Scanner(System.in);
	
	 //rec
	 int xr1=sc.nextInt(), yr1=sc.nextInt(), xr2=sc.nextInt(),yr2=sc.nextInt();
	 int xr3=sc.nextInt(), yr3=sc.nextInt(), xr4=sc.nextInt(),yr4=sc.nextInt();
	
	 Point pr1 = new Point(xr1, yr1);
	 Point pr2 = new Point(xr2, yr2);
	 Point pr3 = new Point(xr3, yr3);
	 Point pr4 = new Point(xr4, yr4);
	 
	 LineSegment lr1 = new LineSegment(pr1, pr2);
	 LineSegment lr2 = new LineSegment(pr2, pr3);
	 LineSegment lr3 = new LineSegment(pr3, pr4);
	 LineSegment lr4 = new LineSegment(pr4, pr1);
	 
	 //diamond
	 int xd1=sc.nextInt(), yd1=sc.nextInt(), xd2=sc.nextInt(),yd2=sc.nextInt();
	 int xd3=sc.nextInt(), yd3=sc.nextInt(), xd4=sc.nextInt(),yd4=sc.nextInt();
	 
	 Point p1 = new Point(xd1, yd1);
	 Point p2 = new Point(xd2, yd2);
	 Point p3 = new Point(xd3, yd3);
	 Point p4 = new Point(xd4, yd4);
	 
	 Point [] pt = new Point [5];
	 pt[0]=p1;  pt[1]=p2;  pt[2]=p3;  pt[3]=p4;  pt[4]=p1;
	 Polygon pg = new Polygon(pt);
	 
	 if(pg.inside(pr1)||pg.inside(pr2)||pg.inside(pr3)||pg.inside(pr4)) {
		 System.out.println("YES");
		 return;
	 }
	
	 
	 LineSegment ld1 = new LineSegment(p1, p2);
	 LineSegment ld2 = new LineSegment(p2, p3);
	 LineSegment ld3 = new LineSegment(p3, p4);
	 LineSegment ld4 = new LineSegment(p4, p1);
	 
	 Rectangle rec = new Rectangle(new Point(Math.min(Math.min(xr3,xr4),Math.min(xr1,xr2)), Math.min(Math.min(yr3,yr4),Math.min(yr1,yr2))), 
			 new Point(Math.max(Math.max(xr3,xr4),Math.max(xr1,xr2)), Math.max(Math.max(yr3,yr4),Math.max(yr1,yr2))) );
	 
	 if(rec.contains(p1)||rec.contains(p2)||rec.contains(p3)||rec.contains(p4)) {
		 System.out.println("YES");
	     return;
	 }
	 
	 if(ld1.intersect(lr1)||ld1.intersect(lr3)||ld1.intersect(lr3)||ld1.intersect(lr4)) {
		 System.out.println("YES");
	     return;
	 }
	 
	 if(ld2.intersect(lr1)||ld2.intersect(lr3)||ld2.intersect(lr3)||ld2.intersect(lr4)) {
		 System.out.println("YES");
	     return;
	 }
	 
	 if(ld3.intersect(lr1)||ld3.intersect(lr3)||ld3.intersect(lr3)||ld3.intersect(lr4)) {
		 System.out.println("YES");
	     return;
	 }
	 
	 if(ld4.intersect(lr1)||ld4.intersect(lr3)||ld4.intersect(lr3)||ld4.intersect(lr4)) {
		 System.out.println("YES");
	     return;
	 }
	 
	 System.out.println("NO");
	 
	 
	 
	 
}
  
  public static class Polygon { 
		// Cases to handle: collinear points, polygons with n < 3

		static final double EPS = 1e-9;
		
		Point[] g; 			//first point = last point, counter-clockwise representation
		
		Polygon(Point[] o) { g = o; }

		double perimeter()
		{
			double sum = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
				sum += g[i].dist(g[i+1]);
			return sum;
		}
		
		double area() 		//clockwise/anti-clockwise check, for convex/concave polygons
		{
			double area = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
				area += g[i].x * g[i+1].y - g[i].y * g[i+1].x;
			return Math.abs(area) / 2.0;			//negative value in case of clockwise
		}

	
		
		boolean inside(Point p)	//for convex/concave polygons - winding number algorithm 
		{
			double sum = 0.0;
			for(int i = 0; i < g.length - 1; ++i)
			{
				double angle = Point.angle(g[i], p, g[i+1]);
				if((Math.abs(angle) < EPS || Math.abs(angle - Math.PI) < EPS) && p.between(g[i], g[i+1]))
					return true;
				if(Point.ccw(p, g[i], g[i+1]))
					sum += angle;
				else
					sum -= angle;
			}

			return Math.abs(2 * Math.PI - Math.abs(sum)) < EPS;		//abs makes it work for clockwise
		}
		/*
		 * Another way if the polygon is convex
		 * 1. Triangulate the poylgon through p
		 * 2. Check if sum areas == poygon area
		 * 3. Handle empty polygon
		 */
		
		

	
		Point centroid()		//center of mass
		{
			double cx = 0.0, cy = 0.0;
			for(int i = 0; i < g.length - 1; i++)
			{
				double x1 = g[i].x, y1 = g[i].y;
				double x2 = g[i+1].x, y2 = g[i+1].y;

				double f = x1 * y2 - x2 * y1;
				cx += (x1 + x2) * f;
				cy += (y1 + y2) * f;
			}
			double area = area();		//remove abs
			cx /= 6.0 * area;
			cy /= 6.0 * area;
			return new Point(cx, cy);
		}
	}
  
   static class LineSegment {

		Point p, q;
		
		LineSegment(Point a, Point b) { p = a; q = b; }
		

		boolean intersect(LineSegment ls)
		{
			Line l1 = new Line(p, q), l2 = new Line(ls.p, ls.q);
			if(l1.parallel(l2))
			{
				if(l1.same(l2))
					return p.between(ls.p, ls.q) || q.between(ls.p, ls.q) || ls.p.between(p, q) || ls.q.between(p, q);
				return false;
			}
			Point c = l1.intersect(l2);
			return c.between(p, q) && c.between(ls.p, ls.q);
		}

	}
  
   static class Rectangle {

		static final double EPS = 1e-9;
		
		Point ll, ur;

		Rectangle(Point a, Point b) { ll = a; ur = b; }

		double area() { return (ur.x - ll.x) * (ur.y - ll.y); }

		boolean contains(Point p)
		{
			return p.x <= ur.x + EPS && p.x + EPS >= ll.x && p.y <= ur.y + EPS && p.y + EPS >= ll.y;
		}

		Rectangle intersect(Rectangle r)
		{
			Point ll = new Point(Math.max(this.ll.x, r.ll.x), Math.max(this.ll.y, r.ll.y));
			Point ur = new Point(Math.min(this.ur.x, r.ur.x), Math.min(this.ur.y, r.ur.y));
			if(Math.abs(ur.x - ll.x) > EPS && Math.abs(ur.y - ll.y) > EPS && this.contains(ll) && this.contains(ur) && r.contains(ll) && r.contains(ur))
				return new Rectangle(ll, ur);
			return null;
		}

	}
   static class Line {

		static final double INF = 1e9, EPS = 1e-9;
		
		double a, b, c;
		
		Line(Point p, Point q)
		{
			if(Math.abs(p.x - q.x) < EPS) {	a = 1; b = 0; c = -p.x;	}
			else
			{
				a = (p.y - q.y) / (q.x - p.x);
				b = 1.0;
				c = -(a * p.x + p.y);
			}
						
		}
		
		Line(Point p, double m) { a = -m; b = 1; c =  -(a * p.x + p.y); } 
		
		boolean parallel(Line l) { return Math.abs(a - l.a) < EPS && Math.abs(b - l.b) < EPS; }
		
		boolean same(Line l) { return parallel(l) && Math.abs(c - l.c) < EPS; }
		
		Point intersect(Line l)
		{
			if(parallel(l))
				return null;
			double x = (b * l.c - c * l.b) / (a * l.b - b * l.a);
			double y;
			if(Math.abs(b) < EPS)
				 y = -l.a * x - l.c;
			else
				y = -a * x - c;
			
			return new Point(x, y);
		}
		
		Point closestPoint(Point p)
		{
			if(Math.abs(b) < EPS) return new Point(-c, p.y);
			if(Math.abs(a) < EPS) return new Point(p.x, -c);
			return intersect(new Line(p, 1 / a));
		}
				
	}

   public static class Vector {

		double x, y; 

		Vector(double a, double b) { x = a; y = b; }

		Vector(Point a, Point b) { this(b.x - a.x, b.y - a.y); }

		Vector scale(double s) { return new Vector(x * s, y * s); }              //s is a non-negative value

		double dot(Vector v) { return (x * v.x + y * v.y); }

		double cross(Vector v) { return x * v.y - y * v.x; }

		double norm2() { return x * x + y * y; }

		Vector reverse() { return new Vector(-x, -y); }

		Vector normalize() 
		{ 
			double d = Math.sqrt(norm2());
			return scale(1 / d);
		}		
	}
   
   static class Point implements Comparable<Point>{

		static final double EPS = 1e-9;

		double x, y;                  

		Point(double a, double b) { x = a; y = b; }  
		
		public int compareTo(Point p)
		{
			if(Math.abs(x - p.x) > EPS) return x > p.x ? 1 : -1;
			if(Math.abs(y - p.y) > EPS) return y > p.y ? 1 : -1;
			return 0;
		}
		static double angle(Point a, Point o, Point b)  // angle AOB
		{
			Vector oa = new Vector(o, a), ob = new Vector(o, b);
			return Math.acos(oa.dot(ob) / Math.sqrt(oa.norm2() * ob.norm2()));
		}
		static boolean ccw(Point p, Point q, Point r)
		{
			return new Vector(p, q).cross(new Vector(p, r)) > 0;
		}
		
		public double dist(Point p) { return Math.sqrt(sq(x - p.x) + sq(y - p.y)); }
		
		static double sq(double x) { return x * x; }
		
		Point rotate(double angle)
		{
			double c = Math.cos(angle), s = Math.sin(angle);
			return new Point(x * c - y * s, x * s + y * c);
		}
		// for integer points and rotation by 90 (counterclockwise) : swap x and y, negate x
		
	
		
		boolean between(Point p, Point q)
		{
			return x < Math.max(p.x, q.x) + EPS && x + EPS > Math.min(p.x, q.x)
					&& y < Math.max(p.y, q.y) + EPS && y + EPS > Math.min(p.y, q.y);
		}
		
		//returns true if it is on the line defined by a and b
	
		//returns true if it is on the ray whose start point is a and passes through b
		// Another way: find closest point and calculate the distance between it and p
	}
  
	static class Scanner {
		StringTokenizer st;
		BufferedReader br;

		public Scanner(InputStream s) {
			br = new BufferedReader(new InputStreamReader(s));
		}

		public String next() throws IOException {
			while (st == null || !st.hasMoreTokens())
				st = new StringTokenizer(br.readLine());
			return st.nextToken();
		}

		public Scanner(String file) throws FileNotFoundException {
			br = new BufferedReader(new FileReader(file));
		}

		public int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public String nextLine() throws IOException {
			return br.readLine();
		}

		public long nextlong() throws IOException {
			String x = next();
			StringBuilder sb = new StringBuilder("0");
			long res = 0, f = 1;
			boolean dec = false, neg = false;
			int start = 0;
			if (x.charAt(0) == '-') {
				neg = true;
				start++;
			}
			for (int i = start; i < x.length(); i++)
				if (x.charAt(i) == '.') {
					res = Long.parseLong(sb.toString());
					sb = new StringBuilder("0");
					dec = true;
				} else {
					sb.append(x.charAt(i));
					if (dec)
						f *= 10;
				}
			res += Long.parseLong(sb.toString()) / f;
			return res * (neg ? -1 : 1);
		}

		public boolean ready() throws IOException {
			return br.ready();
		}

	}
}
