import java.util.*;
import java.io.*;
public class programA {
   	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int s= 2;
		for(int i=0;i<n-1;i++){
			long dis = (long)2*d;
			long dis2 = Math.abs(arr[i]-arr[i+1]);
			if(dis2 == dis)s++;
			else if (dis2 > dis)s+=2;
		}
		System.out.println(s);
   		}
}