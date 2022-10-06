import java.util.*;
import java.io.*;


public class C994{
	static double area(double x1,double y1,double x2,double y2,double x3,double y3){
		return Math.abs((x1 * (y2 - y3) +  
        x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0); 
	}
	public static void main(String args[])throws IOException{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter pw=new PrintWriter(System.out);
		int x11=sc.nextInt();
		int y11=sc.nextInt();
		int x12=sc.nextInt();
		int y12=sc.nextInt();
		int x13=sc.nextInt();
		int y13=sc.nextInt();
		int x14=sc.nextInt();
		int y14=sc.nextInt();
		double x1c=(x11+x12+x13+x14)/4.0;
		double y1c=(y11+y12+y13+y14)/4.0;
		int x21=sc.nextInt();
		int y21=sc.nextInt();
		int x22=sc.nextInt();
		int y22=sc.nextInt();
		int x23=sc.nextInt();
		int y23=sc.nextInt();
		int x24=sc.nextInt();
		int y24=sc.nextInt();
		double x2c=(x21+x22+x23+x24)/4.0;
		double y2c=(y21+y22+y23+y24)/4.0;
		double a1=area(x11,y11,x12,y12,x13,y13)+area(x11,y11,x13,y13,x14,y14);
		double a2=area(x21,y21,x22,y22,x23,y23)+area(x21,y21,x23,y23,x24,y24);
		if(a1==area(x11,y11,x12,y12,x21,y21)+area(x11,y11,x21,y21,x14,y14)+area(x21,y21,x12,y12,x13,y13)+area(x21,y21,x14,y14,x13,y13)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a1==area(x11,y11,x12,y12,x22,y22)+area(x11,y11,x22,y22,x14,y14)+area(x22,y22,x12,y12,x13,y13)+area(x22,y22,x14,y14,x13,y13)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a1==area(x11,y11,x12,y12,x23,y23)+area(x11,y11,x23,y23,x14,y14)+area(x23,y23,x12,y12,x13,y13)+area(x23,y23,x14,y14,x13,y13)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a1==area(x11,y11,x12,y12,x24,y24)+area(x11,y11,x24,y24,x14,y14)+area(x24,y24,x12,y12,x13,y13)+area(x24,y24,x14,y14,x13,y13)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a1==area(x11,y11,x12,y12,x2c,y2c)+area(x11,y11,x2c,y2c,x14,y14)+area(x2c,y2c,x12,y12,x13,y13)+area(x2c,y2c,x14,y14,x13,y13)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a2==area(x21,y21,x22,y22,x11,y11)+area(x21,y21,x11,y11,x24,y24)+area(x11,y11,x22,y22,x23,y23)+area(x11,y11,x24,y24,x23,y23)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a2==area(x21,y21,x22,y22,x12,y12)+area(x21,y21,x12,y12,x24,y24)+area(x12,y12,x22,y22,x23,y23)+area(x12,y12,x24,y24,x23,y23)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a2==area(x21,y21,x22,y22,x13,y13)+area(x21,y21,x13,y13,x24,y24)+area(x13,y13,x22,y22,x23,y23)+area(x13,y13,x24,y24,x23,y23)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a2==area(x21,y21,x22,y22,x14,y14)+area(x21,y21,x14,y14,x24,y24)+area(x14,y14,x22,y22,x23,y23)+area(x14,y14,x24,y24,x23,y23)){
			pw.println("YES");
			pw.close();
			return;
		}
		if(a2==area(x21,y21,x22,y22,x1c,y1c)+area(x21,y21,x14,y14,x2c,y2c)+area(x1c,y1c,x22,y22,x23,y23)+area(x1c,y1c,x24,y24,x23,y23)){
			pw.println("YES");
			pw.close();
			return;
		}
		
		pw.println("NO");
		pw.close();
	}
}