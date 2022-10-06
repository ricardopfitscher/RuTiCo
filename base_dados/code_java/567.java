import java.util.*;
import java.io.*;
public class Main {
    public static boolean contain(int a, int[]b){
        for(int i=0; i<b.length; i++){
            if(b[i]==a) return true;
        }return false;
    }public static int min(int[]b){
        int min =100000;
        for(int i=0; i<b.length; i++){
            if(b[i]<min) min = b[i];
        }return min;
    }public static int max(int[]b){
        int max =0;
        for(int i=0; i<b.length; i++){
            if(b[i]>max) max = b[i];
        }return max;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arrb = new int[n];
		int[] arrg = new int[m];
		int sum =0;
		int c=0;
		int t=n*m;
		 st = new StringTokenizer(br.readLine());
		for(int i=0; i<n ;i++){ arrb[i] =Integer.parseInt(st.nextToken());c++; sum+=arrb[i];}
		 st = new StringTokenizer(br.readLine());
		for(int i=0; i<m ;i++){ arrg[i] =Integer.parseInt(st.nextToken());c++; sum+=arrg[i];}
		for(int i=0; i<n; i++){
		    if(contain(arrb[i],arrg)) sum-=arrb[i];
		   while(c<t){
		        sum += min(arrb);
		        c++;
              }
        }if(max(arrg)<=max(arrb) || sum==0) System.out.println(-1);
		else System.out.println(sum);
		
	}}