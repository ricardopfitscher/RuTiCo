import java.io.*;
import java.util.*;
public class Codechef{
	static int max=Integer.MIN_VALUE;
	static int res=0;
	static int[] checkMax(int arr[],int j){
             int sum=0;
             int x=arr[j];
        		while(x!=0){
        		        if(j+1==15){
        		        	j=0;
        		        }else{
        		        	arr[j+1]=arr[j+1]+1;
        		        }
        		        // if(arr[j+1]%2==0){
        		        // 	sum=sum+arr[j+1];
        		        // 	if(sum>=max){
        		        // 	max=sum;
        		        // }
        		        // }

        		        
        		        x--;
        		        j++;
        		}
        		     return arr;

	}
      

    public static void main(String []args){
       Scanner sc = new Scanner (System.in);
    long a [] = new long [14];
    long b [] = new long [14];
    long p,q,r,s,max = 0;
    for(int i = 0; i < 14; i++) a[i] = sc.nextInt();
    for(int i = 0; i < 14; i++){
      p = a[i]%14;
      q = a[i]/14;
      r = 0;
      s = 0;
      for(int j = 0; j < 14; j++) b[j] = a[j];
      b[i] = 0;
      int j = (i+1)%14;
      for(; r < p; r++) {
        b[j]++;
        j=(j+1)%14;
      }
      for( j = 0; j < 14; j++) {
        b[j] += q;
        if(b[j] % 2 == 0) s+= b[j];
      }
      max = Math.max(max,s);
    }
    System.out.println(max);



    }

}