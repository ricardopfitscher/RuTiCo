import java.io.*;
import java.util.*;
public class Codechef{
	

    public static void main(String []args){
    			Scanner in = new Scanner(System.in);

    long n=in.nextLong();
		long m=in.nextLong();
		long k=in.nextLong();
		long l=in.nextLong();
 
		long j=((k+l)/m);
		if((k+l)%m!=0)j++;
		if((k+l>n) || j*m>n) {
			System.out.println(-1);
		}else {
			
			System.out.println(j);
		}


    }

}