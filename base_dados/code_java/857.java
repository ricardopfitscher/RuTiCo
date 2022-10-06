import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Code {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 HashMap<Double,Integer>h = new HashMap<>();
		 double [] temp = new double[n];
		 int m = 0;
		 for(int i=0;i<n;i++) {
			 String l = br.readLine();
			 int[] x = new int[4];
			 int k=0;
			 boolean t = false;
			 for(int j=0;j<l.length();j++) {
				 if(l.charAt(j)=='(' || l.charAt(j)=='+' || l.charAt(j)==')' || l.charAt(j)=='/')
					 x[k++] = j;
			 }
			 double a = Integer.parseInt(l.substring(x[0]+1,x[1]));
			 double b = Integer.parseInt(l.substring(x[1]+1, x[2]));
			 double c = Integer.parseInt(l.substring(x[3]+1));
			 temp[m++] = (a+b)/c;
			 //System.out.print((a+b)/c + " ");
			if(h.containsKey((a+b)/c))
					h.put((a+b)/c, h.get((a+b)/c)+1);
			else
				h.put((a+b)/c, 1);
		 }
		 //System.out.println(h);
		 for(int i=0;i<n;i++) {
			 System.out.print(h.get(temp[i]) + " ");
		 }
	}
	}
