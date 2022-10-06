import java.io.*;
import java.util.*;
public class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner (System.in);
	    int n = sc.nextInt();
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    int c = sc.nextInt();
	    int ans = 0;
	    int t= sc.nextInt();
	    int arr[] = new int[n];
	    for(int i=0;i<n;i++){
	        int nn = sc.nextInt();
	        ans+=a;
	        if(b<c){
	            ans += (t-nn) * (c - b);
	        }
	    }
	    System.out.println(ans);
	}
}